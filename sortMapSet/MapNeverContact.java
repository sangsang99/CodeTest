import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class MapNeverContact {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        // REAL BUILD AREA
        String[] firstLine = br.readLine().split(" ");
        
        int neverHearCnt = Integer.parseInt(firstLine[0]);
        int neverSeeCnt = Integer.parseInt(firstLine[1]);

        Set<String> neverHear = new HashSet<>(750000, 0.75f);
        Set<String> neverContact = new HashSet<>(750000, 0.75f);

        for (int i = 0; i < neverHearCnt; i++) {
            neverHear.add(br.readLine());
        }

        for (int i = 0; i < neverSeeCnt; i++) {
            String man = br.readLine();
            boolean neverSee = neverHear.contains(man);
            if(neverSee){
                neverContact.add(man);
            }            
        }

        bw.write(neverContact.size() + "\n");
        neverContact.stream().sorted((a, b) -> a.compareTo(b)).forEach(a -> {
            try {
                bw.write(a+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
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
