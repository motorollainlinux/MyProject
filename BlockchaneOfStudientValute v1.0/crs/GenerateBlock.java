import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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
    public void GenBlock() throws NoSuchAlgorithmException {
        String Hash , PrevHash = "";
        int Index = 1;
        String OurHashString;
        String data = "1 transaction: NULL :: 7ae16e3ac9c3a7a6b08e96c8adf54035+; \n";
        ArrayList<Block> Block = new ArrayList<>();
        while (true) {
            System.out.println("Generating block...\n");
            RandomKey();
            Date date = new Date();
            OurHashString = data + Key;
            Hash = hash256(OurHashString);
            if (Hash.contains("00000")) {
                Block newBlock = new Block( Index, date, PrevHash, data, Hash, Key);
                System.out.println("Generated new block" + Index + " whit hash:" + Hash + "!\n");
                Block.add(newBlock);
            }
            Index++;
            PrevHash = Hash;
        }
    }
}
