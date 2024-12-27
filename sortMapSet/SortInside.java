import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SortInside {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        // REAL BUILD AREA

        Long targetNum = Long.parseLong(br.readLine());
        int[] arrCount = new int[10];
        int num = 0;

        while (targetNum > 0) {
            num = (int) (targetNum % 10);
            arrCount[num]++;
            targetNum = targetNum / 10;
        }

        int printCount = 0;

        for (int i = 0; i < arrCount.length; i++) {
            printCount = arrCount[arrCount.length - (i + 1)];
            for (int p = 0; p < printCount; p++) {
                bw.write(arrCount.length - (i + 1) + "");
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
