import java.io.*;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {

        int inputLine = Integer.parseInt(br.readLine());
        
        //간격 배열 세팅
        int[] arrGap = new int[inputLine-1];
        int prevLoc = Integer.parseInt(br.readLine());
        int firstLoc = prevLoc;
        for (int i = 0; i < inputLine-1; i++) {
            int currentLoc = Integer.parseInt(br.readLine());
            int gap = currentLoc - prevLoc;
            arrGap[i] = gap;
            prevLoc = currentLoc;
        }

        //전체 간격값의 최대공약수 구하기
        int allOverGCD = arrGap[0];
        for (int i = 1; i < arrGap.length; i++) {
            allOverGCD = getGCD(allOverGCD, arrGap[i]);
        }

        //필요한 개수 구하기
        int lastLoc = firstLoc; 
        for (int i : arrGap) {
            lastLoc += i;
        }
        int fullfilledTree = (lastLoc-firstLoc)/allOverGCD + 1;
        int currentTree = inputLine;
        int needTree = fullfilledTree - currentTree;

        bw.write(needTree + "\n");
    }

    // 유클리드 호제법 (Euclidean Algorithm)
    private static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
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
