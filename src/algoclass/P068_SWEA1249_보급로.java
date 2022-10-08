package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class P068_SWEA1249_보급로 {
    static int tc, n;
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static BufferedReader br;
    static int[][] checked;

    static class Node {
        int y, x, val;

        public Node(int y, int x, int val) {
            this.y = y;
            this.x = x;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            checked = new int[n][n];
            for (int j = 0; j < n; j++) {
                String[] line = br.readLine().split("");
                for (int k = 0; k < n; k++) {
                    map[j][k] = Integer.parseInt(line[k]);
                    checked[j][k] = Integer.MAX_VALUE;
                }
            }// 입력 완료
            bfs();
            System.out.println("#" + i + " " + checked[n - 1][n - 1]);
        }
    }

    static void bfs() {
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        queue.add(new Node(0, 0, 0));
        checked[0][0] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int y = cur.y;
            int x = cur.x;
            int val = cur.val;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (!checkRange(ny, nx)) continue;
                if (checked[ny][nx] > checked[y][x] + map[ny][nx]) {
                    checked[ny][nx] = checked[y][x] + map[ny][nx];
                    queue.add(new Node(ny, nx, checked[ny][nx]));
                }
            }
        }
    }

    static boolean checkRange(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < n && nx < n;
    }
}
