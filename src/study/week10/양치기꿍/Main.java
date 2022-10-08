package study.week10.양치기꿍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static String[][] map;
    static boolean[][] visited;


    static class node {
        int y, x, sheep, wolf;

        public node(int y, int x, int sheep, int wolf) {
            this.y = y;
            this.x = x;
            this.sheep = sheep;
            this.wolf = wolf;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new String[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = line[j];
            }
        } // 입력 완료

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j] != "#") {
                    bfs(i, j);
                }
            }
        }


    }

    static void bfs(int startY, int startX) {
        Queue<node> queue = new ArrayDeque<>();
        visited = new boolean[r][c];
        if (map[startY][startX] == "v") {
            queue.add(new node(startY, startX, 0, 1));
        } else if (map[startY][startX] == "k") {
            queue.add(new node(startY, startX, 1, 0));
        } else {
            queue.add(new node(startY, startX, 0, 0));
        }

        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            node n = queue.poll();
            int cy = n.y;
            int cx = n.x;
            int cSheep = n.sheep;
            int cWolf = n.wolf;

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (rangeCheck(ny, nx) && !visited[ny][nx] && map[ny][nx] != "#") {
                    if (map[ny][nx] == "v") {
                        queue.add(new node(ny, nx, cSheep, cWolf + 1));
                    } else if (map[ny][nx] == "k") {
                        queue.add(new node(ny, nx, cSheep + 1, cWolf));
                    } else {
                        queue.add(new node(ny, nx, cSheep, cWolf));
                    }
                    visited[ny][nx] = true;
                }
            }
        }
    }

    static boolean rangeCheck(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < r && nx < c;
    }
}
