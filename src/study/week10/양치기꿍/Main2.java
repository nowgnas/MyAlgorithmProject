package study.week10.양치기꿍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static int r, c, sheepCnt, wolfCnt;
    static char[][] map;
    static Queue<node> queue;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class node {
        int y, x;

        public node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];
        queue = new ArrayDeque<>();

        for (int i = 0; i < r; i++) {
            String line2 = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line2.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }
        System.out.println(sheepCnt + " " + wolfCnt);

    }

    private static void bfs(int i, int j) {
        queue.offer(new node(i, j));
        visited[i][j] = true;

        int wolf = 0, sheep = 0;
        while (!queue.isEmpty()) {
            node node = queue.poll();
            int cy = node.y;
            int cx = node.x;

            if (map[cy][cx] == 'v') wolf++;
            else if (map[cy][cx] == 'k') sheep++;

            for (int k = 0; k < 4; k++) {
                int ny = cy + dr[k];
                int nx = cx + dc[k];
                if (checkRange(ny, nx)) continue;
                if (!visited[ny][nx] && map[ny][nx] != '#') {
                    queue.offer(new node(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
        if (wolf < sheep) sheepCnt += sheep;
        else wolfCnt += wolf;

    }

    static boolean checkRange(int ny, int nx) {
        return ny < 0 || nx < 0 || ny >= r || nx >= c;
    }
}
