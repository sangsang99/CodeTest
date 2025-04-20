import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {

        int queStackCnt = Integer.parseInt(br.readLine());
        String[] types = br.readLine().split(" ");
        String[] elements = br.readLine().split(" ");
        Deque<Long> pipe = new ArrayDeque<>(); 

        for (int i = 0; i < queStackCnt; i++) {
            if(types[i].equals("0")){
                long element = Long.parseLong(elements[i]);
                pipe.add(element);
            }
        }

        StringBuilder sb = new StringBuilder();

        int pushCnt = Integer.parseInt(br.readLine());
        String[] pushes = br.readLine().split(" ");

        for (int i = 0; i < pushCnt; i++) {
            long push = Long.parseLong(pushes[i]);
            pipe.addFirst(push);
            push = pipe.removeLast();
            sb.append(push + " ");
        }
        bw.write(sb.toString());
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
