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
    static int[][] dirLikeHorse = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};

    static int[][] map;
    static Queue<Node> queue;

    static class Node {
        int y, x, k;

        public Node(int y, int x, int k) {
            this.y = y;
            this.x = x;
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
        visited = new boolean[h][w][k+1];
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
        queue.add(new Node(0, 0, k));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int y = cur.y;
            int x = cur.x;
            int move = cur.k;
//            if (y == w - 1 && x == h - 1) return move;
            System.out.println(move);


            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (!rangeChekc(ny, nx) || visited[ny][nx][0]) continue;
                if (map[ny][nx] == 1) continue;
                queue.add(new Node(ny, nx, move + 1));
                visited[ny][nx][0] = true;
            }

            for (int i = 0; i < dirLikeHorse.length; i++) {
                int ny = y + dirLikeHorse[i][0];
                int nx = x + dirLikeHorse[i][1];
                if (!rangeChekc(ny, nx) || visited[ny][nx][k]) continue;
                if (map[ny][nx] == 1) continue;
                queue.add(new Node(ny, nx, move + 1));
                visited[ny][nx][k] = true;
            }
        }
        return -1;
    }

    static boolean rangeChekc(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < w && nx < w;
    }

    static void horse(int y, int x, int move) {

    }
}