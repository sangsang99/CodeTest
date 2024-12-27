import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SetSymDiff {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        // REAL BUILD AREA
        String[] firstLine = br.readLine().split(" ");
        
        int cntA = Integer.parseInt(firstLine[0]);
        int cntB = Integer.parseInt(firstLine[1]);

        Set<Long> setA = new HashSet<>(300000, 0.75f);
        Set<Long> setB = new HashSet<>(300000, 0.75f);
        Set<Long> onlyA = new HashSet<>(300000, 0.75f);
        Set<Long> onlyB = new HashSet<>(300000, 0.75f);

        StringTokenizer A = new StringTokenizer(br.readLine());
        for (int i = 0; i < cntA; i++) {
            setA.add(Long.parseLong(A.nextToken()));
        }

        StringTokenizer B = new StringTokenizer(br.readLine());
        for (int i = 0; i < cntB; i++) {
            setB.add(Long.parseLong(B.nextToken()));
        }

        for (Long a : setA) {
            if(!setB.contains(a)) onlyA.add(a);
        }
        for (Long b : setB) {
            if(!setA.contains(b)) onlyB.add(b);
        }

        bw.write(onlyA.size() + onlyB.size() + "");

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
