package kang.벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class node { // 좌표 , 이동횟수, 부서진 ㅇㅕ부 ?!
        int x, y, move;
        boolean crash;

        public node(int x, int y, int move, boolean crash) {
            super();
            this.x = x;
            this.y = y;
            this.move = move;
            this.crash = crash;
        }

    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s[] = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]); // 세로
        M = Integer.parseInt(s[1]); // 가로

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s2[] = bf.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s2[j]);
            }
        } // 입력 완료

        visited = new boolean[N][M][2]; // 0 이면 부신 벽이 없는 것 , 1 인경우 부신 벽이 있다

        int result = bfs(0, 0);
        System.out.println(result);
    }

    private static int bfs(int i, int j) {
        Queue<node> q = new ArrayDeque<>();
        q.offer(new node(i, j, 1, false));

        while (!q.isEmpty()) {
            node n = q.poll();
            int x = n.x;
            int y = n.y;
            int m = n.move;
            boolean c = n.crash;

            if (x == N - 1 && y == M - 1) return n.move; // 도착지점

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                int nextcnt = m + 1; // 하나 다음 칸

                if (map[nx][ny] == 0) { // 0 인 경우 그냥 이동 !
                    if (!c && !visited[nx][ny][0]) { // 만약 부순 벽이 없으면 ?!
                        q.add(new node(nx, ny, nextcnt, false));
                        visited[nx][ny][0] = true;
                    } else if (c && !visited[nx][ny][1]) { // 만약 부순 벽이 있으면 !?
                        q.add(new node(nx, ny, nextcnt, true));
                        visited[nx][ny][1] = true;
                    }
                } else if (map[nx][ny] == 1) { // 벽인 경우 ?!
                    if (!c) { // 벽을 부순적이 없다면 벽을 부순다 ~
                        q.add(new node(nx, ny, nextcnt, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }

        }
        return -1; // 이동을 실패하는 경우
    }
}