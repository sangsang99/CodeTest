import java.io.*;
import java.util.*;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        int lineCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < lineCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == B) {
                bw.write(A + "\n");
                continue;
            } else if (A > B) {
                // A == Bigger;
                // B == Smaller;
            } else if (A < B) {
                int temp = A;
                A = B;
                B = temp;
            }

            List<Integer> divList = getDivs(A);
            Collections.sort(divList);

            for (Integer div : divList) {
                if ((B * div) % A == 0) {
                    bw.write(B * div + "\n");
                    break;
                }
            }
        }
    }

    public static List<Integer> getMinDivs(int num) {
        List<Integer> divList = new ArrayList<>();
        int target = num;
        int div = 2;

        while (target > 0) {
            int remain = target % div;
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

    public static List<Integer> getDivs(int num) {
        List<Integer> divList = new ArrayList<>();
        int div = 2;

        while (div <= num) {
            int remain = num % div;
            if (remain == 0) {
                divList.add(div);
            }
            div++;
            if (num == 1) {
                divList.add(1); // 1을 약수집합에 넣으려면
                break;
            }
        }

        return divList;
    }

    public static void main(String[] args) throws IOException {

        // BufferedReader와 BufferedWriter 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 처리 실행
        doProcess(br, bw);

        br.close();
        bw.flush();
        bw.close();
    }
}
