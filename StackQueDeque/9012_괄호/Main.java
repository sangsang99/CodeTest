import java.io.*;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        int lineCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < lineCnt; i++) {
            String[] prths = br.readLine().split("");
            Stack<String> stack = new Stack<>();

            try {
                for (String ps : prths) {
                    if (ps.equals("("))
                        stack.push("(");
                    else if (ps.equals(")") && stack.peek().equals("("))
                        stack.pop();
                }
            } catch (EmptyStackException e) {
                bw.write("NO\n");
                continue;
            }
            if (stack.empty())
                bw.write("YES\n");
            else
                bw.write("NO\n");

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
