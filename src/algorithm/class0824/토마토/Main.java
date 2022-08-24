package algorithm.class0824.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static int M, N;
    static int[][] map;
    static int[] inputs;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        M = inputs[1];

        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            inputs = new int[N];
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                int item = inputs[j];
                map[i][j] = item;
                if (item == 1) { // 시작 지잠 저장
                    queue.add(new int[]{i, j});
                }
            }
        } // 입력 끝
        // 시작지점 마다 bfs를 돌아야 함
        int answer = Integer.MIN_VALUE;
        int size = queue.size();
        for (int k = 0; k < size; k++) {
            bfs();
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    sb.append(-1);
                    System.out.print(sb);
                    System.exit(0);
                }
                answer = Math.max(answer, map[i][j]);
            }
        }
        sb.append((answer - 1));
        System.out.print(sb);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];
                // 지도 밖이면 다음 좌표
                if (ny < 0 || nx < 0 || ny >= M || nx >= N) continue;

                // 지도 내 일 경우
                if (map[ny][nx] == 0) {
                    map[ny][nx] = map[curY][curX] + 1;
                    queue.add(new int[]{ny, nx});
                }
            }
        }

    }
}
