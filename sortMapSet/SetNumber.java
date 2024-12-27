import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SetNumber {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        // REAL BUILD AREA
        int havingCnt = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> havingNum = new HashMap<>(havingCnt * 2, 0.75f);

        StringTokenizer havingTk = new StringTokenizer(br.readLine());
        for (int i = 0; i < havingCnt; i++) {
            Long card = Long.parseLong(havingTk.nextToken());
            havingNum.put(card, 1);
        }

        int questionCnt = Integer.parseInt(br.readLine());
        StringTokenizer questionTk = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < questionCnt; i++) {
            int hasNum = havingNum.getOrDefault(Long.parseLong(questionTk.nextToken()), 0);
            bw.write(hasNum + " ");
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
