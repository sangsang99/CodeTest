import java.io.*;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        int orderCnt = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < orderCnt; i++) {
            String[] orderSet = br.readLine().split(" ");
            String orderCase = orderSet[0];
            try {
                switch (orderCase) {
                    case "1":
                        int inputNum = Integer.parseInt(orderSet[1]);
                        stack.push(inputNum);
                        break;
                    case "2":
                        bw.write(stack.pop()+"\n");
                        break;
                    case "3":
                        bw.write(stack.size()+"\n");
                        break;
                    case "4":
                        if (stack.isEmpty())
                            bw.write("1\n");
                        else
                            bw.write("0\n");
                        break;
                    case "5":
                        bw.write(stack.peek()+"\n");
                        break;
                }
            } catch (EmptyStackException  e) {
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
