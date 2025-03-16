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
            bw.write("++++++++++++++++++++++++++++\n");
            int oldCircleSize = oldCircle.size();
            boolean beforeGuide = true;
            if (guide > 0) {
                for (int a = 1; a <= oldCircleSize; a++) {
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

                    if (a == guide && oldCircle.size() == 0 && beforeGuide) {
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

                    // bw.write("a:" + a + " nextGuide:" + guide + " oldSize:" + oldCircle.size() + " newSize:"
                    //         + newCircle.size() + " isbefore:" + beforeGuide + "\n");
                }
                if (!beforeGuide && oldCircle.size() == 0) {
                    showDeque(newCircle, bw);
                    oldCircle.addAll(newCircle);
                    newCircle.clear();
                    beforeGuide = true;
                    continue;
                }
            }
            if (guide < 0) {
                for (int b = -1; b >= -oldCircleSize; b--) {
                    if (oldCircle.size() > 0 && b != guide) {
                        if (beforeGuide) {
                            newCircle.addFirst(oldCircle.pollFirst());
                        } else {
                            newCircle.addLast(oldCircle.pollLast());
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
                    // bw.write("b:" + b + " nextGuide:" + guide + " oldSize:" + oldCircle.size() + " newSize:"
                    //         + newCircle.size() + " isbefore:" + beforeGuide + "\n");

                }
                if (!beforeGuide && oldCircle.size() == 0) {
                    showDeque(newCircle, bw);
                    oldCircle.addAll(newCircle);
                    newCircle.clear();
                    beforeGuide = true;
                    continue;
                }
            }
        }

        if(oldCircle.size() ==1) permut.add(oldCircle.poll());
        showDeque(permut, bw);
    }

    public static void showDeque(Deque<Integer> deque, BufferedWriter bw) throws IOException {
        deque.stream().forEach((i) -> {
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
