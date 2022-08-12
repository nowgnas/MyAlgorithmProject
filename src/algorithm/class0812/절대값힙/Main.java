package algorithm.class0812.절대값힙;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static PriorityQueue<Integer> queue2 = new PriorityQueue<>(); // 음수 큐


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());// 양수 큐
        StringBuilder sb = new StringBuilder();

//
//        PriorityQueue<Integer> queue1 = new PriorityQueue<>(); // 양수 큐
//        PriorityQueue<Integer> queue2 = new PriorityQueue<>(); // 음수 큐

        // 큐를 음수 큐 , 양수 큐 나누어서 해결하는 방법
//       for (int i = 0; i < n; i++) {
//            int num = Integer.parseInt(br.readLine());
//
//            if (num > 0) {
//                queue1.add(num);
//            } else if (num < 0) {
//                queue2.add(Math.abs(num));
//            } else {
//                if (queue1.isEmpty() && queue2.isEmpty()) {
//                    sb.append(0).append('\n');
//                } else if (!queue1.isEmpty() && queue2.isEmpty()) {
//                    sb.append(queue1.poll()).append("\n");
//                } else if (queue1.isEmpty()) {
//                    sb.append(queue2.poll() * -1).append("\n");
//                } else {
//                    if (queue1.peek() < queue2.peek()) {
//                        sb.append(queue1.poll()).append("\n");
//                    } else {
//                        sb.append(queue2.poll() * -1).append("\n");
//                    }
//                }
//            }
//
//        }


        // 우선순위 큐를 하나로 만들고 Comparator로 비교해서 출력하는 방법
        PriorityQueue<int[]> queue1;
        queue1 = new PriorityQueue<>(n, (ints, t1) -> {

            if (ints[0] < t1[0]) {
                return -1;
            } else if (ints[0] > t1[0]) {
                return 1;
            } else {
                if (ints[1] < t1[1]) {
                    return -1;
                } else if (ints[1] > t1[1]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                queue1.add(new int[]{num, 1});
            } else if (num < 0) {
                queue1.add(new int[]{Math.abs(num), -1});
            } else {
                if (queue1.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    int[] poll = queue1.poll();
                    int num2 = poll[0];
                    int bit = poll[1];

                    sb.append(num2 * bit).append("\n");
                }
            }
        }
        System.out.println(sb);

    }
}
