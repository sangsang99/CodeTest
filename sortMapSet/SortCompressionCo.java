import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SortCompressionCo {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        // REAL BUILD AREA

        int corLength = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long[] orgNumbers = new Long[corLength];
        Map<Long, Integer> sortedNumberMap = new HashMap<>();
        int[] pressedNumbers = new int[corLength];

        for (int i = 0; i < corLength; i++) {
            Long coordinate = Long.parseLong(st.nextToken());
            orgNumbers[i] = coordinate;
        }

        Set<Long> sortedSet = new TreeSet<>(Arrays.asList(orgNumbers));
        Iterator<Long> sortedSetIter = sortedSet.iterator();

        for (int i = 0; i < sortedSet.size(); i++) {
            if(!sortedSetIter.hasNext()) break;
            sortedNumberMap.put(sortedSetIter.next(), i);
        }

        for (int i = 0; i < orgNumbers.length; i++) {
            int pressedNumber = sortedNumberMap.get(orgNumbers[i]);
            pressedNumbers[i] = pressedNumber;
        }

        for (int i : pressedNumbers) {
            bw.write(i + " ");
        }

        // REAL BUILD AREA END
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./text.txt")));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        doProcess(br, bw);
        br.close();
        bw.flush();
        bw.close();
    }
}
