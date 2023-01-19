
import java.util.Date;

public class GenerateBlock {

    public String Key = "";
    public void RandomKey() {
        char[] str = new char[5];
        int RandomNumber;
        Key = "";
        for (int i = 0; i < 5; i++) {
            RandomNumber = 65 + (int) (Math.random() * 25);
            str[i] = (char) RandomNumber;
        }
        for (int i = 0; i < 5; i++) {
            Key = Key + str[i];
        }

    }
    public void GenBlock() {
        int Hash, PrevHash = 0x0, Index, PrevIndex = 0x0;
        String OurHashString;
        String data = "gjnrliururguhgruguseilesgue\nrugrssiusliurhifeneif\ngorgbniusgeeiseipwwp\neufjv\nqw98wrujfujforg8694uiij\n";
        while (true) {
            Index = PrevIndex + 1;
            RandomKey();
            Date date = new Date();
            OurHashString = data + Key;
            //Hash = DigestUtils.sha256Hex(OurHashString);      //set to SHA256
            Hash = OurHashString.hashCode();                    //set to SHA256
            OurHashString = String.format("%#X", Hash);         //set to SHA256
            System.out.println( "Key:" + OurHashString);
            if (OurHashString.contains("0x00")) {
                Block newBlock = new Block(PrevHash, Index, date, data, Hash, Key);
                System.out.println(newBlock);
            }
            PrevIndex = Index;
            PrevHash = Hash;
        }
    }
}
