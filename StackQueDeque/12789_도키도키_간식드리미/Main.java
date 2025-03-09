import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {

        int waitCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] waitLine = new int[waitCount];
        Stack<Integer> waitStack = new Stack<>();

        for (int i = 0; i < waitLine.length; i++) {
            waitLine[i] = Integer.parseInt(st.nextToken());
        }

        int nowTurn = 1;
        for (int i = 0; i < waitLine.length; i++) {
            int front = waitLine[i];
            if (front == nowTurn) {
                nowTurn++;
            } else if (waitStack.empty()) {
                waitStack.push(front);
            } else if (waitStack.peek() == nowTurn) {
                nowTurn++;
                waitStack.pop();
                i--;
            } else {
                waitStack.push(front);
            }
        }

        int remain = waitStack.size();
        for (int i = 0; i < remain; i++) {
            if (waitStack.pop() == nowTurn) {
                nowTurn++;
            }
        }

        if (nowTurn == ++waitCount && waitStack.empty()) {
            bw.write("Nice\n");
        } else {
            bw.write("Sad\n");
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
