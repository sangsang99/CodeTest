import java.io.*;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        String[] question = br.readLine().split(" ");
        int start = Integer.parseInt(question[0]);
        int end = Integer.parseInt(question[1]);
        for (int i = start; i <= end; i++) {
            if(isPrineNum(i)) bw.write(i+"\n");           
        }
    }

    // 소수 구하기
    private static boolean isPrineNum(int num){
        if(num < 2) return false;
        int div = 2;
        while (div <= Math.sqrt((double)num)){
            if(num%div == 0) return false;
            else div++;
        }
        return true;
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
