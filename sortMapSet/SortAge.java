import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class SortAge {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        // REAL BUILD AREA

        int memberLength = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        Map<Integer, String>[] memberMapByAge = new HashMap[200];

        for (int i = 0; i < memberLength; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String member = st.nextToken();
            if (memberMapByAge[age - 1] == null)
                memberMapByAge[age - 1] = new HashMap<>();
            memberMapByAge[age - 1].put(i, member);
        }

        for (int i = 0; i < memberMapByAge.length; i++) {
            if (memberMapByAge[i] == null) {continue;}

            Map<Integer, String> sortedMap = new TreeMap<>(memberMapByAge[i]);
            Iterator<Integer> iter = sortedMap.keySet().stream().iterator();
 
            while (iter.hasNext()) {
            int joinNum = iter.next();
            String name = (String) memberMapByAge[i].get(joinNum);

            bw.write((i + 1) + " " + name + "\n");
            }
        }
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
