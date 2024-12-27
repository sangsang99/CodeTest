import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SetString {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        // REAL BUILD AREA
        StringTokenizer st = new StringTokenizer(br.readLine());
        int havingCnt = Integer.parseInt(st.nextToken());
        int questionCnt = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> havingWord = new HashMap<>(havingCnt * 2, 0.75f);

        for (int i = 0; i < havingCnt; i++) {
            String card = br.readLine();
            havingWord.put(card, 1);
        }
        
        int hasCnt = 0;

        for (int i = 0; i < questionCnt; i++) {
            int hasStr = havingWord.getOrDefault(br.readLine(), 0);
            hasCnt += hasStr;
        }

        bw.write(hasCnt + " ");
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
