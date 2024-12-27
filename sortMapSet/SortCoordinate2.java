import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SortCoordinate2 {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        // REAL BUILD AREA

        int corLength = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        List<Integer>[] yArray_xList = new List[200001];

        for (int i = 0; i < corLength; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()) + 100000;
            if (yArray_xList[y] == null) {
                yArray_xList[y] = new ArrayList<>();
            }
            yArray_xList[y].add(x);
        }

        for (int y = 0; y < yArray_xList.length; y++) {
            if (yArray_xList[y] == null)
                continue;

            yArray_xList[y].sort(null);
            for (int x : yArray_xList[y]) {
                bw.write((x) + " " + (y - 100000) + "\n");
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
