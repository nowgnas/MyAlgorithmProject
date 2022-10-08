package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P075_BJ2636_치즈 {
    static int w, h, total, tmp, time;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new int[h][w];


        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) total++;
            }
        }
        tmp = total;
        while (true) {
            visited = new boolean[h][w];
            bfs();
            time++;
            if (total == 0) {
                break;
            }
            tmp = total;
        }
        System.out.println(time);
        System.out.println(tmp);

        // 녹아서 없어지는데 걸리는 시간
        // 모두 녹기 한시간 전에 남아 있는 치즈 조각 놓여 있는 칸의 개수
    }

    static void bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int y = n.y;
            int x = n.x;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (!rangeCheck(ny, nx) || visited[ny][nx]) continue;
                if (map[ny][nx] == 1) {
                    map[ny][nx] = 0;
                    visited[ny][nx] = true;
                    total--;
                } else {
                    queue.add(new Node(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    static boolean rangeCheck(int ny, int nx) {
        return ny >= 0 && ny < h && nx >= 0 && nx < w;
    }
}
