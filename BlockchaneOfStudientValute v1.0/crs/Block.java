import java.util.Date;

public class Block {
    String Hash,PrevHash, Key, data;
    int Index;
    Date date;
    public Block( int Index, Date date, String PrevHash, String data, String Hash, String Key) {
        this.Hash = Hash;
        this.Index = Index;
        this.date = date;
        this.data = data;
        this.PrevHash = PrevHash;
        this.Key = Key;
    }
}
