import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class MapPorket {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        // REAL BUILD AREA
        String[] firstLine = br.readLine().split(" ");
        int dexCnt = Integer.parseInt(firstLine[0]);
        int quizCnt = Integer.parseInt(firstLine[1]);

        Map<Integer, String> dexMap = new HashMap<>(dexCnt * 2, 0.75f);
        Map<String, Integer> rvsMap = new HashMap<>(dexCnt * 2, 0.75f);

        for (int i = 1; i <= dexCnt; i++) {
            String mon = br.readLine();
            dexMap.put(i, mon);
            rvsMap.put(mon, i);
        }

        for (int i = 0; i < quizCnt; i++) {
            String quiz = br.readLine();

            String mon = quiz;
            int foundIndex = rvsMap.getOrDefault(mon, 0);

            if (foundIndex != 0) {
                bw.write(foundIndex + "\n");
                continue;
            } else if (foundIndex == 0) {
                int index = Integer.parseInt(quiz);
                String foundMon = dexMap.get(index);
                bw.write(foundMon + "\n");
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
