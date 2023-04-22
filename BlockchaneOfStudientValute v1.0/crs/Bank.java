import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    String log_name;
    public Bank(String log_name) {this.log_name = log_name;}

    void GetBlock(int times, Bank b1, Bank b2, Bank b3, Bank b4) throws NoSuchAlgorithmException, IOException {
        GenerateBlock GB = new GenerateBlock();
        GB.GenBlock(times, log_name , b1, b2, b3, b4);
    }
    void Consensus(String logs1, String logs2, String logs3) throws IOException {
        File OurLogs = new File(log_name);
        File log1 = new File(logs1);
        File log2 = new File(logs2);
        File log3 = new File(logs3);
        ArrayList<String> Ourstr = new ArrayList<>();
        String str1, str2, str3;
        FileReader OurFR = new FileReader(OurLogs);
        Scanner OurScan = new Scanner(OurFR);
        FileReader FR1 = new FileReader(log1);
        Scanner ScanLog1 = new Scanner(FR1);
        FileReader FR2 = new FileReader(log2);
        Scanner ScanLog2 = new Scanner(FR2);
        FileReader FR3 = new FileReader(log3);
        Scanner ScanLog3 = new Scanner(FR3);
        while (OurScan.hasNextLine()) {
            Ourstr.add(OurScan.nextLine());
        }
        int i = 0;
        for (; ScanLog1.hasNextLine() && ScanLog2.hasNextLine() && ScanLog3.hasNextLine(); i++) {
            str1 = ScanLog1.nextLine();
            str2 = ScanLog2.nextLine();
            str3 = ScanLog3.nextLine();
            if (!Ourstr.get(i).equals(str1) || !Ourstr.get(i).equals(str2) || !Ourstr.get(i).equals(str3)) {
                if (str1.equals(str2) && str2.equals(str3)) {
                    Ourstr.set(i, str1);
                } else if (str1.equals(str2)) {
                    Ourstr.set(i, str1);
                } else if (str2.equals(str3)) {
                    Ourstr.set(i, str2);
                } else if (str1.equals(str3)) {
                    Ourstr.set(i, str1);
                }
            }
        }
            OurFR.close();
            OurScan.close();
            FR1.close();
            ScanLog1.close();
            FR2.close();
            ScanLog2.close();
            FR3.close();
            ScanLog3.close();
            FileWriter FW = new FileWriter(OurLogs);
        for (i = 0; i < Ourstr.size(); i++) {
            FW.write(Ourstr.get(i) + "\n");
        }
        FW.close();
        }
    }
