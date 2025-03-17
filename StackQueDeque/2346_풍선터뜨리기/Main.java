import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

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

    public static boolean isReverse(Deque<Integer> old, Deque<Integer> ps) throws IOException {
        if (old.size() < 2) {
            return false;
        }
        int first = old.peekFirst();
        int pop = ps.peekLast();
        return first < pop;
    }

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
        int guide = cardSets[permut.peek() - 1];

        while (oldCircle.size() > 1) {
            int oldCircleSize = oldCircle.size();
            boolean isReverse = isReverse(oldCircle, permut);
            boolean beforeGuide = true;
            int oldGuide = guide;
            int absGuide = Math.abs(guide);

            for (int a = 1; a <= oldCircleSize; a++) {
                if (oldCircle.size() > 0 && a != absGuide) {
                    if (beforeGuide) {
                        if (isReverse && oldGuide > 0) {
                            newCircle.addLast(oldCircle.removeLast());
                        }
                        if (!isReverse && oldGuide < 0) {
                            newCircle.addLast(oldCircle.removeLast());
                        }
                        if (isReverse && oldGuide < 0) {
                            newCircle.addLast(oldCircle.removeFirst());
                        }
                        if (!isReverse && oldGuide > 0) {
                            newCircle.addLast(oldCircle.removeFirst());
                        }
                    } else {
                        if (isReverse && oldGuide > 0) {
                            newCircle.addFirst(oldCircle.removeFirst());
                        }
                        if (!isReverse && oldGuide < 0) {
                            newCircle.addFirst(oldCircle.removeFirst());
                        }
                        if (isReverse && oldGuide < 0) {
                            newCircle.addFirst(oldCircle.removeLast());
                        }
                        if (!isReverse && oldGuide > 0) {
                            newCircle.addFirst(oldCircle.removeLast());
                        }
                    }
                } else if (oldCircle.size() > 0 && a == absGuide && beforeGuide) {
                    int pop = 0;
                    if (isReverse && oldGuide > 0)
                        pop = oldCircle.removeLast();
                    if (!isReverse && oldGuide < 0)
                        pop = oldCircle.removeLast();
                    if (isReverse && oldGuide < 0)
                        pop = oldCircle.removeFirst();
                    if (!isReverse && oldGuide > 0)
                        pop = oldCircle.removeFirst();
                    permut.add(pop);
                    guide = cardSets[pop - 1];
                    beforeGuide = false;
                }
                if (oldCircle.size() == 0 && beforeGuide) {

                    int[] move = { absGuide % newCircle.size() > 0 ? absGuide : newCircle.size() };
                    int[] tempGuide = { absGuide };
                    isReverse = isReverse(newCircle, permut);

                    if ((isReverse && oldGuide > 0) || (!isReverse && oldGuide < 0)) {
                        move[0] = newCircle.size() - absGuide % newCircle.size() + 1;
                    }
                    

                    while (move[0] > 0) {
                        newCircle.stream().forEach((i) -> {
                            if (--move[0] == 0) {
                                permut.add(i);
                                newCircle.remove(i);
                                tempGuide[0] = cardSets[i - 1];
                            } else if (move[0] < 0) {
                                newCircle.addFirst(newCircle.pollLast());
                            }
                        });
                    }

                    guide = tempGuide[0];
                    beforeGuide = false;
                }
            }
            if (!beforeGuide && oldCircle.size() == 0) {
                oldCircle.addAll(newCircle);
                newCircle.clear();
                beforeGuide = true;
                continue;
            }

        }

        if (oldCircle.size() == 1) {
            permut.add(oldCircle.poll());
        }
        showDeque(permut, bw);
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
