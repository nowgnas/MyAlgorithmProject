package algorithm.class0930.말이되고픈원숭이;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int k, w, h;
    static boolean[][][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2}; //말이 이동할 수 있는 8방향
    static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static int[][] map;
    static Queue<Node> queue;

    static class Node {
        int y, x, move, k;

        public Node(int y, int x, int move, int k) {
            this.y = y;
            this.x = x;
            this.move = move;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w][k + 1];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }// 입력 끝
        int result = bfs();
        System.out.println(result);

    }

    static int bfs() {
        queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 0, k));
        visited[0][0][k] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int y = cur.y;
            int x = cur.x;
            int move = cur.move;
            int ck = cur.k;
            if (y == h - 1 && x == w - 1) return move;


            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (!rangeCheck(ny, nx) || visited[ny][nx][ck]) continue;
                if (map[ny][nx] == 1) continue;
                queue.add(new Node(ny, nx, move + 1, ck));
                visited[ny][nx][ck] = true;
            }
            if (ck > 0) {
                for (int i = 0; i < 8; i++) {
                    int ny = y + hdy[i];
                    int nx = x + hdx[i];
                    if (!rangeCheck(ny, nx) || visited[ny][nx][ck - 1] || map[ny][nx] == 1) continue;
                    queue.add(new Node(ny, nx, move + 1, ck - 1));
                    visited[ny][nx][ck - 1] = true;
                }
            }
        }
        return -1;
    }

    static boolean rangeCheck(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < h && nx < w;
    }

}