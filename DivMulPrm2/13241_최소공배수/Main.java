import java.io.*;
import java.util.*;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        if (A == B) {
            bw.write(A + "\n");
        } else if (A > B) {
            // A == Bigger;
            // B == Smaller;
        } else if (A < B) {
            long temp = A;
            A = B;
            B = temp;
        }

        List<Long> divList = getDivs(A);
        Collections.sort(divList);

        for (long div : divList) {
            if ((B * div) % A == 0) {
                bw.write(B * div + "\n");
                break;
            }
        }
    }

    public static List<Long> getMinDivs(long num) {
        List<Long> divList = new ArrayList<>();
        long target = num;
        long div = 2;

        while (target > 0) {
            long remain = target % div;
            if (remain == 0) {
                divList.add(div);
                target = target / div;
                div = 2;
            } else {
                div++;
            }
            if (target == 1) {
                // divList.add(1); // 1을 약수집합에 넣으려면
                break;
            }
        }

        return divList;
    }

    public static List<Long> getDivs(long num) {
        List<Long> divList = new ArrayList<>();
        long div = 2;

        while (div <= num) {
            long remain = num % div;
            if (remain == 0) {
                divList.add(div);
            }
            div++;
            if (num == 1) {
                divList.add(1L); // 1을 약수집합에 넣으려면
                break;
            }
        }

        return divList;
    }

    public static void main(String[] args) throws IOException {

        // BufferedReader와 BufferedWriter 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("DivMulPrm2/13241_최소공배수/data.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 처리 실행
        doProcess(br, bw);

        br.close();
        bw.flush();
        bw.close();
    }
}
