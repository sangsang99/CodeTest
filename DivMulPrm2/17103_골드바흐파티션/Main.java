import java.io.*;
import java.util.Arrays;
public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        int lineCnt = Integer.parseInt(br.readLine());

        for (int line = 0; line < lineCnt; line++) {
            int evenNum = Integer.parseInt(br.readLine());
            int pairCnt = 0;

            //  에라토스테네스의 체
            boolean[] isPrime = new boolean[evenNum+1];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;
            for (int i = 2; i * i <= evenNum; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j < evenNum; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            // 쌍 구하기
            for (int j = 2; j <= evenNum/2; j++) {
                if( isPrime[j] && isPrime[evenNum-j] ){
                    pairCnt++;
                }
            }

            bw.write(pairCnt + "\n");
        }
    }

    public static void main(String[] args) throws IOException {

        // BufferedReader와 BufferedWriter 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./data.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 처리 실행
        doProcess(br, bw);

        br.close();
        bw.flush();
        bw.close();
    }
}
