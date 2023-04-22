import java.io.IOException;
import java.security.NoSuchAlgorithmException;

class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        int t = 1000000;
        Bank bank1 = new Bank("Bank1_log.txt");
        Bank bank2 = new Bank("Bank2_log.txt");
        Bank bank3 = new Bank("Bank3_log.txt");
        Bank bank4 = new Bank("Bank4_log.txt");
        bank1.GetBlock(t, bank1, bank2, bank3, bank4);
        bank1.Consensus(bank2.log_name, bank3.log_name, bank4.log_name);
    }
}
