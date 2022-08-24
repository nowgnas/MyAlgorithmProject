package algorithm.class0824.아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int N, sharkSize, eatCnt, time;
    static int[][] map;
    static boolean[][] visited;
    static int[] shark;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
        if (o1[0] == o2[0]) {
            return o1[1] - o2[1];
        }
        return o1[0] - o2[0];
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        sharkSize = 2;

        shark = new int[2];
        for (int i = 0; i < N; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = line[j];
                if (map[i][j] == 9) {
                    shark[0] = i;
                    shark[1] = j;
                }
            }
        } // 입력 끝

        // 처음 상어 크기는 2
        // 크기가 같으면 지나갈 수 있고 크기가 작으면 먹을 수 있다
        // 가장 가까운 물고기를 먹는다
        // 가장 위, 가장 왼쪽 물고기
        // 먹으면 빈칸
        // 상어 크기가 3이면 3마리 물고기 먹어야 함
        bfs(shark[0], shark[1]);
        System.out.println(time);


    }

    static void bfs(int y, int x) {
        visited[y][x] = true;
        queue.offer(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 지도 밖이면 다음 좌표
                if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                // 조건 달기
                // 다음 좌표가 1 2 3 4 5 6인 경우?
                if (!visited[ny][nx] && sharkSize > map[curY][curX]) {
                    // 갈 수 있고, 물고기를 먹을 수 있다
                    time++;
                    eatCnt++;
                    if (eatCnt == sharkSize) {
                        sharkSize++;
                        eatCnt = 0;
                    }
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
                if (!visited[ny][nx] && map[ny][nx] == map[curY][curX]) {
                    // 물고기와 크기가 같은 경우 지나갈 수 있다
                    time++;
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }


    }
}
