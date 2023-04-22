import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class GenerateBlock {

    public static String hash256(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return bytesToHex(md.digest());
    }
    public static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
    public String Key = "";
    public void RandomKey() {
        final int KeyLength = 20;
        char[] str = new char[KeyLength];
        int RandomNumber;
        Key = "";
        for (int i = 0; i < KeyLength; i++) {
            RandomNumber = 65 + (int) (Math.random() * 25);
            str[i] = (char) RandomNumber;
        }
        for (int i = 0; i < KeyLength; i++) {
            Key = Key + str[i];
        }
    }
    void echo(Block block, Bank b1) throws IOException {
        File file1 = new File(b1.log_name);
        FileWriter fw1 = new FileWriter(file1, true);
        fw1.write(block.Hash + " : Block " + block.Index + " : " + block.data + " | " + block.date + " | " + block.PrevHash + " + " + block.Key + "\n");
        fw1.close();
    }
    public void GenBlock(int times, String filename, Bank b1, Bank b2, Bank b3, Bank b4) throws NoSuchAlgorithmException, IOException {
        String Hash, PrevHash = "0";
        int Index = 1;
        String OurHashString;
        File logs = new File(filename);
        String data = "1 transaction: NULL :: 7ae16e3ac9c3a7a6b08e96c8adf54035+;";
        while (times > 0) {
            System.out.println(times + "\n");
            RandomKey();
            Date date = new Date();
            OurHashString = PrevHash + Index + date + data + Key;
            Hash = hash256(OurHashString);
            if (Hash.contains("000000")) {
                Block newBlock = new Block( Index, date, PrevHash, data, Hash, Key);
                Index++;
                PrevHash = Hash;
                echo(newBlock, b1);
                echo(newBlock, b2);
                echo(newBlock, b3);
                echo(newBlock, b4);
            }
            times--;
        }

    }
}
