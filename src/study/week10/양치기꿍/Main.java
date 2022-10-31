package study.week10.양치기꿍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c, sheep = 0, wolf = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static String[][] map;
    static boolean[][] visited;


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
                if (!"#".equals(map[i][j]) && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(sheep + " " + wolf);

    }

    static void bfs(int startY, int startX) {
        int cntWolf = 0;
        int cntSheep = 0;
        Queue<node> queue = new ArrayDeque<>();

        queue.add(new node(startY, startX));
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            node n = queue.poll();
            int cy = n.y;
            int cx = n.x;
            if ("v".equals(map[cy][cx])) {
                cntWolf++;
            } else if ("k".equals(map[cy][cx])) {
                cntSheep++;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (rangeCheck(ny, nx)) {
                    if (!visited[ny][nx] && !"#".equals(map[ny][nx])) {
                        queue.add(new node(ny, nx));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        if (cntWolf > cntSheep) {
            sheep += cntSheep;
        } else if (cntSheep > cntWolf) {
            wolf += cntWolf;
        }
    }

    static boolean rangeCheck(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < r && nx < c;
    }
}
