import java.io.*;
import java.util.*;

public class SetStringParts {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        // REAL BUILD AREA
        String str = br.readLine();
        int strLeng = str.length();
        Set<String> partSet = new HashSet<>(300000, 0.75f);

        for (int leng = 1; leng <= strLeng; leng++) {
            for (int at = 0; at + leng <= strLeng; at++) {
                partSet.add(str.substring(at, at + leng));
            }
        }

        bw.write(partSet.size() + "");
        // REAL BUILD AREA END
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./text.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        doProcess(br, bw);
        br.close();
        bw.flush();
        bw.close();
    }
}
