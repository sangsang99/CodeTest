import java.io.*;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        int inputLine = Integer.parseInt(br.readLine());
        for (int i = 0; i < inputLine; i++) {
            long num = Long.parseLong(br.readLine());
            bw.write(getNextPrineNum(num) + "\n");
        }

    }

    // 소수 구하기
    private static long getNextPrineNum(long num){
        if(num < 2) return 2;
        int div = 2;
        while (div <= Math.sqrt((double)num)){
            if(num%div == 0) return getNextPrineNum(num+1);
            else div++;
        }
        return num;
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
