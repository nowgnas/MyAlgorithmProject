package study.week6.인구이동;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, l, r;
    static int[][] map, direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        while (true) {
            boolean[][] visited = new boolean[n][n];
            boolean flag = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) continue;
                    int set = bfs(i, j, visited);
                    if (set >= 2) {
                        flag = true;
                    }
                }
            }
            if (!flag) break;
            count++;
        }
        System.out.println(count);
    }

    static int bfs(int y, int x, boolean[][] visited) {
        Queue<Node> q = new ArrayDeque<>();
        Queue<Node> queue = new ArrayDeque<>();
        q.add(new Node(y, x));
        queue.add(new Node(y, x));
        visited[y][x] = true;
        int total = map[y][x];
        int cnt = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int cy = cur.y;
            int cx = cur.x;

            for (int i = 0; i < 4; i++) {
                int ny = cy + direction[i][0];
                int nx = cx + direction[i][1];
                if (checkMap(ny, nx)) {
                    if (visited[ny][nx]) continue;
                    int diff = Math.abs(map[cy][cx] - map[ny][nx]);
                    if (diff < l || diff > r) continue;
                    q.add(new Node(ny, nx));
                    queue.add(new Node(ny, nx));
                    total += map[ny][nx];
                    visited[ny][nx] = true;
                    cnt++;
                }

            }
        }
        if (cnt == 1) {
            return 0;
        } else {
            int avg = total / cnt;
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                map[cur.y][cur.x] = avg;
            }
        }
        return cnt;
    }

    static boolean checkMap(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < n;
    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}