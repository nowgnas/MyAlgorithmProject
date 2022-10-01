package study.week9.전쟁_전투;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (line[j] == 'W') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        } // 입력 끝
        int w = 0; // map 1
        int b = 0; // map 0

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int val = bfs(i, j);
                    w += val * val;
                } else if (!visited[i][j]) {
                    int val = bfs(i, j);
                    b += val * val;
                }
            }
        }
        System.out.println(w + " " + b);
    }

    static int bfs(int y, int x) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(y, x));
        visited[y][x] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int cy = cur.y;
            int cx = cur.x;

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (!checkRange(ny, nx) || visited[ny][nx]) continue;
                if (map[cy][cx] == map[ny][nx]) {
                    queue.add(new Node(ny, nx));
                    visited[ny][nx] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static boolean checkRange(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < m && nx < n;
    }
}
