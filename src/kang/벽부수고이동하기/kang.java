package kang.벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class kang {
    static class node {
        int x, y, dist;

        public node(int x, int y, int dist) {
            super();
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s[] = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]); // 세로
        M = Integer.parseInt(s[1]); // 가로

        map = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            String s2[] = bf.readLine().split("");
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = Integer.parseInt(s2[j - 1]);
            }
        } // 입력 완료

        visited = new boolean[N + 1][M + 1];
        System.out.println(bfs(1, 1)); // (1,1) 부터 시작
    }

    private static int bfs(int i, int j) {
        Queue<node> q = new ArrayDeque<>();
        q.offer(new node(i, j, 1));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            node n = q.poll();
            int x = n.x;
            int y = n.y;
            int move = n.dist;

            if (x == N - 1 && y == M - 1) return move; // 도착지점

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (!visited[nx][ny]) {
                    if (map[nx][ny] == 1) {
                        // 다음이 0 인경우 점프로 이동 가능 .. 4 방의 다음을 보자
                        for (int k = 0; k < 4; k++) {
                            int kx = nx + dx[k];
                            int ky = ny + dy[k];

                            if (kx < 0 || ky < 0 || kx >= N || ky >= M) continue;
                            if (!visited[kx][ky]) {
                                visited[kx][ky] = true;
                                q.offer(new node(kx, ky, move + 1));
                            }
                        }


                    } else { // 0 인 경우 그냥 이동 !
                        visited[nx][ny] = true;
                        q.offer(new node(nx, ny, move + 1));
                    }
                }
            }
        }
        return -1; // 이동을 실패하는 경우

    }

}