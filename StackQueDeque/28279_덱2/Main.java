import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        int orderCnt = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < orderCnt; i++) {
            String[] orderSet = br.readLine().split(" ");
            String order = orderSet[0];
            int inputNum;
            int extractNum;
            try {
                switch (order) {
                    case "1":
                        inputNum = Integer.parseInt(orderSet[1]);
                        deque.push(inputNum);
                        // deque.add(inputNum);
                        // deque.addFirst(inputNum);
                        // deque.offerFirst(inputNum);
                        // deque.offer(inputNum);
                        break;
                    case "2":
                        inputNum = Integer.parseInt(orderSet[1]);
                        deque.addLast(inputNum);
                        // deque.offerLast(inputNum);
                        break;
                    case "3":
                        extractNum = deque.removeFirst();
                        // extractNum = deque.pollFirst();
                        // extractNum = deque.remove();
                        // extractNum = deque.poll();
                        // extractNum = deque.element();
                        // extractNum = deque.pop();
                        bw.write(extractNum + "\n");
                        break;
                    case "4":
                        extractNum = deque.removeLast();
                        // extractNum = deque.pollLast();
                        bw.write(extractNum + "\n");
                        break;
                    case "5":
                        bw.write(deque.size() + "\n");
                        break;
                    case "6":
                        bw.write((deque.isEmpty() ? 1 : 0) + "\n");
                        break;
                    case "7":
                        extractNum = deque.getFirst();
                        // extractNum = deque.peekFirst();
                        // extractNum = deque.peek();
                        bw.write(extractNum + "\n");
                        break;
                    case "8":
                        extractNum = deque.getLast();
                        // extractNum = deque.peekLast();
                        bw.write(extractNum + "\n");
                        break;
                }
            } catch (NoSuchElementException e) {
                bw.write("-1\n");
            }
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
