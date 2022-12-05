
import java.util.*;

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
        String data = "Amogus is my love!\n ruguseilesgue\n rugrssiusliurhifeneif\n gorgbniusgeeiseipwwpeufjvnqw98wrujfujforg8694uiij\n";
        while (true) {
            Index = PrevIndex + 1;
            RandomKey();
            Date date = new Date();
            OurHashString = data + Key;
            Hash = OurHashString.hashCode();
            if (Hash < 0) {
                Hash = Hash * (-1);
            }
            Hash = Hash * 2;
            OurHashString = String.format("%#X", Hash);
            System.out.println( "Key:" + OurHashString);
            if (OurHashString.contains("0x00000")) {
                Block newBlock = new Block(Index, date, data, Hash, PrevHash, Key);
                //OutInConsole
                System.out.println(newBlock);
                //EndOfOutInConsole
            }
            PrevIndex = Index;
            PrevHash = Hash;
        }
    }
}
