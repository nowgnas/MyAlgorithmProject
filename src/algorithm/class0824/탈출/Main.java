package algorithm.class0824.탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static int R, C;
    static int[] inputs;
    static String[][] map;
    static int[][] matrix, visited, visited2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = inputs[0];
        C = inputs[1];
        matrix = new int[3][];
        map = new String[R][C];
        visited = new int[R][C];
        visited2 = new int[R][C];

        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                String item = line[j];
                map[i][j] = item;
                if ("D".equals(item)) matrix[0] = new int[]{i, j};
                if ("*".equals(item)) matrix[1] = new int[]{i, j};
                if ("S".equals(item)) matrix[2] = new int[]{i, j};
            }
        }
        // matrix D * S

        // 물에는 bfs를 사용
        bfs(matrix[1][0], matrix[1][1], visited);
        /*
        [0, 2, 1]
        [4, 3, 2]
        [5, 0, 3]
        */
        bfs(matrix[2][0], matrix[2][1], visited2);
        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
        System.out.println();
        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(visited2[i]));
        }
    }

    static void bfs(int y, int x, int[][] visited) {
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        visited[y][x] = 0;
        queue.offer(new int[]{y, x});

        while (!queue.isEmpty()) {
            // 큐에서 pop 한 좌표
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                if (visited[ny][nx] == 0 && ".D".contains(map[ny][nx])) {
                    // 방문 하지 않고 .인 경우만 갈 수 있음
                    visited[ny][nx] = visited[curY][curX] + 1;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }
}
