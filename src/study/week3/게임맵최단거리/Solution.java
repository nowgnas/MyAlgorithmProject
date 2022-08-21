package study.week3.게임맵최단거리;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    static int cnt;

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        int N = maps.length;
        int M = maps[0].length;

        int[][] visited = new int[N][M];


        bfs(visited, maps);
        cnt = visited[N - 1][M - 1] > 0 ? visited[N - 1][M - 1] : -1;
        System.out.println(cnt);

    }

    static void bfs(int[][] visited, int[][] map) {
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        Queue<int[]> queue = new ArrayDeque<>();

        visited[0][0] = 1;
        queue.offer(new int[]{0, 0});

        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); // queue 젤 위에 좌표 꺼내기

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= visited.length || nx >= visited[0].length) continue;
                if (visited[ny][nx] == 0 && map[ny][nx] == 1) {
                    queue.offer(new int[]{ny, nx});
                    visited[ny][nx] = visited[cur[0]][cur[1]] + 1;
                }
            }
        }
    }
}
