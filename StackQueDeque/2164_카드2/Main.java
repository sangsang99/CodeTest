import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        int cardCount = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= cardCount; i++) {
            queue.add(i);         
        }

        while (queue.size() > 1) {
            // Step1 맨위(앞)의 카드 한장제거
            queue.poll();

            // Step2 그다음 맨위의 카드 한장을 맨아래로 이동
            if(queue.size() > 1){
                int move = queue.poll();
                queue.add(move);
            }
        }

        bw.write(queue.peek()+"\n");
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
