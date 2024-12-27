import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SetEnterLog {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        // REAL BUILD AREA
        int logCnt = Integer.parseInt(br.readLine());
        Set<String> empSet = new HashSet<>(logCnt, 0.75f);

        for (int i = 0; i < logCnt; i++) {
            String[] log = br.readLine().split(" ");
            String emp = log[0];
            String state = log[1];
            if(state.equals("enter")) {empSet.add(emp); continue;}
            if(state.equals("leave")) {empSet.remove(emp); continue;}
        }

        Set<String> sortSet = new TreeSet<>((a,b)->b.compareTo(a));
        sortSet.addAll(empSet);
        // Set<String> sortSet = empSet.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toCollection(LinkedHashSet::new));

        for (String emp : sortSet) {
            bw.write(emp + "\n");
        }

        // Iterator<String> iterSet = sortSet.iterator();
        // while (iterSet.hasNext()) {
        //     String emp = iterSet.next();
        //     bw.write(emp + "\n");
        // }

        // sortSet.stream().forEach(emp -> {
        //     try {
        //         bw.write(emp + "\n");
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // });

        // sortSet.forEach(emp -> {
        //     try {
        //         bw.write(emp + "\n");
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // });
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
