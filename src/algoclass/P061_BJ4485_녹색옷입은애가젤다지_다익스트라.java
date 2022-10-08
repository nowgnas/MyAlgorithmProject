package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P061_BJ4485_녹색옷입은애가젤다지_다익스트라 {
    static int N, tc, X, Y;
    static int[][] map;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = -1;
        while (true) {
            tc++;
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                } // 각 테스트 케이스 입력 끝
            }

            Y = 0;
            X = 0;

            int D[][] = new int[N][N];
            boolean[][] visited = new boolean[N][N];

            for (int[] line :
                    D) {
                Arrays.fill(line, Integer.MAX_VALUE);
            }

            D[Y][X] = map[Y][X];

            Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
            queue.offer(new int[]{Y, X, map[Y][X]});
            visited[Y][X] = true;
            int cnt = 0;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int curY = cur[0];
                int curX = cur[1];
                int curVal = map[curY][curX];


                for (int j = 0; j < 4; j++) {
                    int ny = curY + dy[j];
                    int nx = curX + dx[j];

                    if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
                        if (D[ny][nx] > D[curY][curX] + map[ny][nx]) {
                            D[ny][nx] = D[curY][curX] + map[ny][nx];
                            queue.offer(new int[]{ny, nx, curVal + map[ny][nx]});
                        }
                    }
                }
            }
            System.out.println("Problem " + tc + ":" + " " + D[N - 1][N - 1]);
        }

    }
}
