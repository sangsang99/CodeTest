import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class SortWord {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        // REAL BUILD AREA

        int dataLength = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        Set<String>[] wordSetArr = new HashSet[50];

        for (int i = 0; i < dataLength; i++) {
            String word = br.readLine();
            if(wordSetArr[word.length()-1] == null) wordSetArr[word.length()-1] = new HashSet<String>();
            wordSetArr[word.length()-1].add(word);
        }

        for (int i = 0; i < wordSetArr.length; i++) {

            if(wordSetArr[i] == null) continue;

            wordSetArr[i].stream().sorted().forEach(word -> {
                try {
                    bw.write(word + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // ArrayList<String> list = new ArrayList<>(wordSetArr[i]);
            // Collections.sort(list);
            // for (String word : list) {
            //     bw.write(word+ "\n");
            // }

            // Iterator<String> iterSet = wordSetArr[i].iterator();
            // while(iterSet.hasNext()){
            //     bw.write(iterSet.next() + "\n");
            // }


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
