import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void doProcess(BufferedReader br, BufferedWriter bw) throws IOException {
        int circleSize = Integer.parseInt(br.readLine());
        String[] tempCards = br.readLine().split(" ");
        int[] cardSets = new int[circleSize];
        for (int i = 0; i < circleSize; i++) {
            cardSets[i] = Integer.parseInt(tempCards[i]);
        }

        Deque<Integer> oldCircle = new ArrayDeque<>();
        Deque<Integer> newCircle = new ArrayDeque<>();
        Deque<Integer> permut = new ArrayDeque<>();

        for (int i = 1; i <= circleSize; i++) {
            oldCircle.add(i);
        }

        permut.add(oldCircle.pollFirst());
        int guide = cardSets[0];

        while (oldCircle.size() > 1) {
            int oldCircleSize = oldCircle.size();
            boolean beforeGuide = true;
            for (int a = 1; a <= oldCircleSize && guide > 0; a++) {
                bw.write("a: " + a + " guide: " + guide + "\n");
                if (oldCircle.size() > 0 && a != guide) {
                    if (beforeGuide) {
                        newCircle.addFirst(oldCircle.pollFirst());
                    } else {
                        newCircle.addLast(oldCircle.pollLast());
                    }
                } else if (oldCircle.size() > 0 && a == guide) {
                    int pop = oldCircle.pollFirst();
                    permut.add(pop);
                    guide = cardSets[pop - 1];
                    beforeGuide = false;
                }

                if (a == guide && oldCircle.size() == 0 && beforeGuide)  {
                    int[] move = { guide % newCircle.size() };
                    int[] tempGuide = { guide };
                    if (move[0] == 0) {
                        move[0] = newCircle.size();
                    }
                    newCircle.stream().forEach((i) -> {
                        move[0]--;
                        if (move[0] == 0) {
                            permut.add(i);
                            tempGuide[0] = cardSets[i - 1];
                        }
                    });
                    guide = tempGuide[0];
                    beforeGuide = false;
                }
            }
            if (!beforeGuide) {
                newCircle.stream().forEach((i) -> {
                    try {
                        bw.write(i + " ");
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                });
    
                bw.write(" / last: " + permut.peekLast() + " guide: " + guide + "\n");
                bw.write("\n");
                oldCircle = newCircle;
                continue;
            }
            for (int b = -1; b >= -oldCircleSize && guide < 0; b--) {

                bw.write("b: " + b + " guide: " + guide + "\n");
                if (oldCircle.size() > 0 && b != guide) {
                    if (beforeGuide) {
                        newCircle.addFirst(oldCircle.pollLast());
                    } else {
                        newCircle.addLast(oldCircle.pollFirst());
                    }
                } else if (oldCircle.size() > 0 && b == guide) {
                    int pop = oldCircle.pollLast();
                    permut.add(pop);
                    guide = cardSets[pop - 1];
                    beforeGuide = false;
                }

                if (b == guide && oldCircle.size() == 0 && beforeGuide) {
                    int[] move = { -guide % newCircle.size() };
                    int[] tempGuide = { guide };
                    if (move[0] == 0) {
                        move[0] = newCircle.size();
                    }
                    newCircle.stream().forEach((i) -> {
                        move[0]--;
                        if (move[0] == 0) {
                            permut.add(i);
                            tempGuide[0] = cardSets[i - 1];
                        }
                    });
                    guide = tempGuide[0];
                    beforeGuide = false;

                }
            }

            newCircle.stream().forEach((i) -> {
                try {
                    bw.write(i + " ");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });

            bw.write(" / last: " + permut.peekLast() + " guide: " + guide + "\n");
            bw.write("\n");
            oldCircle = newCircle;
        }

        permut.stream().forEach((i) -> {
            try {
                bw.write(i + " ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.write("\n");

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
