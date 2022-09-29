package ssafy보충.알고리즘.탈주범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int t, n, m, r, c, l, cnt;
    static int[][] map;
    static int[][] command = {
            {0, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 1},
            {1, 0, 0, 1}
    };
    static int[] dy = {-1, 0, 1, 0};// 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};


    static class Node {
        int y, x, val, time;

        public Node(int y, int x, int val, int time) {
            this.y = y;
            this.x = x;
            this.val = val;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken()); // 맨홀 세로
            c = Integer.parseInt(st.nextToken()); // 맨홀 가로
            l = Integer.parseInt(st.nextToken()); // 소요시간
            map = new int[n][m];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }// 입력 완료

            cnt = 1;
            bfs(r, c);
            System.out.println("#" + i + " " + cnt);

        }
    }

    static void bfs(int r, int c) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(r, c, map[r][c], 1));
        map[r][c] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int cy = cur.y;
            int cx = cur.x;
            int cv = cur.val;
            int ct = cur.time;
            int[] direction = command[cv];

            for (int i = 0; i < direction.length; i++) {
                if (direction[i] == 0) continue;
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (!rangeCheck(ny, nx)) continue;
                if (map[ny][nx] == 0) continue;
                if (command[map[ny][nx]][(i + 2) % 4] == 1) {
                    if (ct + 1 <= l) {
                        queue.add(new Node(ny, nx, map[ny][nx], ct + 1));
                        map[ny][nx] = 0;
                        cnt += 1;
                    }
                }
            }
        }
    }

    static boolean rangeCheck(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < m;
    }

}
