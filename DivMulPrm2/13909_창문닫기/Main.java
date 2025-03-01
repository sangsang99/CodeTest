import java.io.*;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        int count = Integer.parseInt(br.readLine());
        int openCount = (int) Math.sqrt((double) count);
        bw.write(openCount + "\n");
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
