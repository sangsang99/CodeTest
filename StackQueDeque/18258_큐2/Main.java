import java.io.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        int orderCnt = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;

        for (int i = 0; i < orderCnt; i++) {
            String[] orderSet = br.readLine().split(" ");
            String order = orderSet[0];
            try {
                switch (order) {
                    case "push":
                        int inputNum = Integer.parseInt(orderSet[1]);
                        queue.add(inputNum);
                        last = inputNum;
                        break;
                    case "pop":
                        bw.write(queue.remove() + "\n");
                        break;
                    case "size":
                        bw.write(queue.size() + "\n");
                        break;
                    case "empty":
                        if (queue.isEmpty())
                            bw.write("1\n");
                        else
                            bw.write("0\n");
                        break;
                    case "front":
                        bw.write(queue.element() + "\n");
                        break;
                    case "back":
                        if (queue.isEmpty())
                            bw.write("-1\n");
                        else {
                            bw.write(last + "\n");
                        }
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
