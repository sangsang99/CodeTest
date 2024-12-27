import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SortCoordinate {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        // REAL BUILD AREA

        int corLength = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        List<Integer>[] xArray_yList = new List[200001];

        for (int i = 0; i < corLength; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + 100000;
            int y = Integer.parseInt(st.nextToken());
            if (xArray_yList[x] == null) {
                xArray_yList[x] = new ArrayList<>();
            }
            xArray_yList[x].add(y);
        }

        for (int x = 0; x < xArray_yList.length; x++) {
            if (xArray_yList[x] == null)
                continue;

            xArray_yList[x].sort(null);
            for (int y : xArray_yList[x]) {
                bw.write((x - 100000) + " " + y + "\n");
            }
            
            // int[] yCount = new int[200001];
            // for (Integer y : xArray_yList[x]) {
            //     yCount[y + 100000]++;
            // }

            // for (int y = 0; y < yCount.length; y++) {
            //     int printCount = yCount[y];
            //     if (printCount > 0) {
            //         bw.write((x - 100000) + " " + (y - 100000) + "\n");
            //     }
            // }

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
