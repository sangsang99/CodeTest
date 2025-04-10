import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        int circleSize = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        String[] tempCards = br.readLine().split(" ");
        boolean[] arrIsPop = new boolean[circleSize+1];
        Arrays.fill(arrIsPop, false);
        for (int i = 1; i <= circleSize; i++) {
            map.put(i, Integer.parseInt(tempCards[i-1]));
        }

        //Start
        int now = 1;
        arrIsPop[now] = true;
        int popCount = 1;
        int moveTo = map.get(now); 
        bw.write(now + " ");

        while (popCount < circleSize) {
            while(moveTo != 0){
                if(moveTo > 0){
                    now = (now + 1) <= circleSize ? (now + 1) : 1;
                    if(!arrIsPop[now]){
                        moveTo--;
                    } 
                }

                if(moveTo < 0){
                    now = (now - 1) >= 1 ? (now - 1) : circleSize;
                    if(!arrIsPop[now]){
                        moveTo++;
                    }
                }

            }

            arrIsPop[now] = true;
            popCount++;
            moveTo = map.get(now); 
            bw.write(now + " ");
                
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
