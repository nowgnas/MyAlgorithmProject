package study.week7.유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int t, m, n, k, cnt;
    static int[][] map, direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int mX = Integer.parseInt(st.nextToken());
                int mY = Integer.parseInt(st.nextToken());
                map[mY][mX] = 1;
            }
            cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (map[j][l] == 1) {
                        bfs(j, l);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void bfs(int y, int x) {
        Queue<Node> q = new ArrayDeque<>();

        q.add(new Node(y, x));
        map[y][x] = 2;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int cy = cur.y;
            int cx = cur.x;

            for (int i = 0; i < 4; i++) {
                int ny = cy + direction[i][0];
                int nx = cx + direction[i][1];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 2) continue;
                if (map[ny][nx] == 1) {
                    map[ny][nx] = 2;
                    q.add(new Node(ny, nx));
                }
            }
        }
    }
}
