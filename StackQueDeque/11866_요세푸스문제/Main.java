import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        String[] quiz = br.readLine().split(" ");
        int circleSize = Integer.parseInt(quiz[0]);
        int target = Integer.parseInt(quiz[1]);
        int turn = 1;
        Queue<Integer> oldCircle = new LinkedList<>();
        Queue<Integer> newCircle = new LinkedList<>();
        Queue<Integer> permut = new LinkedList<>();
        for (int i = 1; i <= circleSize; i++) {
            oldCircle.add(i);
        }

        while (oldCircle.size() > 0) {
            int oneCycle = oldCircle.size();
            for (int i = 0; i < oneCycle; i++) {
                if (turn % target == 0) {
                    permut.add(oldCircle.poll());
                } else {
                    newCircle.add(oldCircle.poll());
                }
                turn++;
            }
            oldCircle = newCircle;
        }

        StringBuffer sb = new StringBuffer();
        sb.append("<");
        for (Integer man : permut) {
            sb.append(man + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        bw.write(sb.toString()+"\n");
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
