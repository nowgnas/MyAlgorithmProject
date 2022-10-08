package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P048_BJ1697_숨바꼭질 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[] inputs;
    static boolean[] visited;
    static int[] count;
    static Queue<Integer> queue;


    public static void main(String[] args) throws IOException {
        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        K = inputs[1];
        visited = new boolean[200001];
        count = new int[200001];

        bfs();
    }

    private static void bfs() {
        queue = new ArrayDeque<>();

        visited[N] = true;
        queue.offer(N);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == K) {
                System.out.println(count[K]);
                return;
            }

            int back = cur - 1;
            int front = cur + 1;
            int multiple = cur * 2;

            if (back >= 0 && !visited[back]) {
                visited[back] = true;
                count[back] = count[cur] + 1;
                queue.offer(back);
            }
            if (front < 200001 && !visited[front]) {
                visited[front] = true;
                count[front] = count[cur] + 1;
                queue.offer(front);
            }
            if (multiple < 200001 && !visited[multiple]) {
                visited[multiple] = true;
                count[multiple] = count[cur] + 1;
                queue.offer(multiple);
            }
        }
    }
}
