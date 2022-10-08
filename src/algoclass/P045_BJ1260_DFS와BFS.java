package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P045_BJ1260_DFS와BFS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, V;
    static int[] inputs;
    static boolean[] visited;
    static int[][] adjMatrix;

    public static void main(String[] args) throws IOException {
        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = inputs[0];
        M = inputs[1];
        V = inputs[2];

        visited = new boolean[N + 1];
        adjMatrix = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adjMatrix[line[0]][line[1]] = adjMatrix[line[1]][line[0]] = 1;
        }
        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs();
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        System.out.print(cur + " ");

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && adjMatrix[cur][i] != 0) {
                dfs(i);
            }
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();

        visited[V] = true;
        queue.offer(V);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");

            // 현재 정점의 인접 정점들에 큐에 넣어서 차후 탐색하도록 만들기
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && adjMatrix[cur][i] != 0) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
