import java.io.*;
import java.util.Stack;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {

        String line = br.readLine();

        while (line != null && !line.equals(".")) {
            String[] crushedLine = line.split("");
            Stack<String> psStack = new Stack<>();

            for (String piece : crushedLine) {
                if (piece.equals(".")) {
                    if (psStack.empty()) {
                        bw.write("yes\n");
                        break;
                    } else {
                        bw.write("no\n");
                        break;
                    }
                } else if (piece.equals("(") || piece.equals("[")) {
                    psStack.push(piece);
                } else if (piece.equals(")")) {
                    if (psStack.empty()) {
                        bw.write("no\n");
                        break;
                    } else if (psStack.peek().equals("(")) {
                        psStack.pop();
                    } else {
                        bw.write("no\n");
                        break;
                    }
                } else if (piece.equals("]")) {
                    if (psStack.empty()) {
                        bw.write("no\n");
                        break;
                    } else if (psStack.peek().equals("[")) {
                        psStack.pop();
                    } else {
                        bw.write("no\n");
                        break;
                    }
                }

            }
            line = br.readLine();
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
