import java.io.*;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        int orderCnt = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < orderCnt; i++) {
            int num = Integer.parseInt(br.readLine());
            try {
                if(num == 0){
                    stack.pop();
                    continue;
                }
                stack.push(num);
            } catch (EmptyStackException  e) {
                bw.write("not allowed case");
            } 
        }

        int sum = stack.stream().mapToInt(Integer::intValue).sum();
        bw.write(sum + "\n");
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
