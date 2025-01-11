import java.io.*;
import java.util.*;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numeA = Integer.parseInt(st.nextToken());
        int denoA = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int numeB = Integer.parseInt(st.nextToken());
        int denoB = Integer.parseInt(st.nextToken());
        
        int LCM = getLCM(denoA, denoB);

        int numeSum = numeA * (LCM/denoA) + numeB * (LCM/denoB);
        int denoSum = LCM;

        int GCDsum = getGCD(numeSum, denoSum);
        bw.write(numeSum/GCDsum + " " + denoSum/GCDsum);
    }

    // 유클리드 호제법 (Euclidean Algorithm)
    private static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    

    public static int getLCM(int numA, int numB) {
        int LCM = numA * numB / getGCD(numA, numB);
        return LCM;
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
