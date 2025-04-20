import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MainBefore {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {

        int queStackCnt = Integer.parseInt(br.readLine());
        String[] types = br.readLine().split(" ");
        String[] elements = br.readLine().split(" ");

        List<Deque<Long>> dequeList = new ArrayList<>();
        for (int i = 0; i < queStackCnt; i++) {
            long element = Long.parseLong(elements[i]);
            Deque<Long> deque = new ArrayDeque<Long>();
            deque.add(types[i].equals("0") ? element : -1 * element);
            dequeList.add(deque);
        }

        StringBuilder sb = new StringBuilder();

        int pushCnt = Integer.parseInt(br.readLine());
        String[] pushes = br.readLine().split(" ");

        for (int i = 0; i < pushCnt; i++) {
            long push = Long.parseLong(pushes[i]);

            for (Deque<Long> deque : dequeList) {
                long type = deque.peek() > 0 ? 1 : -1;
                deque.addLast(push * type);
                if (type > 0)
                    push = deque.poll() * type;
                else
                    push = deque.pollLast() * type;
            }
            sb.append(push).append(" ");
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
