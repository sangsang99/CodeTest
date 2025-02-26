import java.io.*;
import java.util.Arrays;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        int question = Integer.parseInt(br.readLine());
        while (question != 0) {
            int n = question;
            int n2 = n*2;
            int count = 0;
            boolean[] isPrime = new boolean[n2+1];
            Arrays.fill(isPrime, true);
            isPrime[0] = isPrime[1] = false;
            for (int i = 2; i*i <= n2; i++) {
                if(isPrime[i]){
                    //에라토스테네스의 체
                    for (int j = i * i; j <= n2; j += i) {
                        isPrime[j] = false;
                    }                
                }
            }
            for (int i = n+1; i <= n2; i++) {
                if(isPrime[i]) count++;
            }
            bw.write(count + "\n");
            question = Integer.parseInt(br.readLine());
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
