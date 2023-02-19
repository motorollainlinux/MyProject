import java.util.Date;

public class Block {
    String Hash, PrevHash;
    int Index;
    String Key, data;
    Date date;
    public Block( int index, Date date, String prevHash, String data, String hash, String key) {
        this.PrevHash = PrevHash;
        this.Index = Index;
        this.date = date;
        this.data = data;
        this.Hash = Hash;
        this.Key = Key;
    }
}
