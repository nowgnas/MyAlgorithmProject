package study.week11.봄버맨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, n, ticktock;
    static node[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class node {
        int y, x, time;
        String type;

        public node(int y, int x, int time, String type) {
            this.y = y;
            this.x = x;
            this.time = time;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new node[r][c];

        for (int i = 0; i < r; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = new node(i, j, 0, line[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            // n초가 흐를 때
            checkBomb();
            if (i % 2 == 1) {
                // 폭탄 채우기
                fillBomb();
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j].type);
            }
            System.out.println();
        }
    }

    static void checkBomb() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                node n = map[i][j];
                if (n.time == 2) {
                    bomb(i, j);
                } else if (n.type.equals("O")) {
                    n.time++;
                }
            }
        }
    }

    static void fillBomb() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                node n = map[i][j];
                if (!n.type.equals("O")) {
                    n.type = "O";
                    n.time = 0;
                }
            }
        }
    }

    static void bomb(int y, int x) {
        map[y][x].type = ".";
        map[y][x].time = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (checkRange(ny, nx)) {
                map[ny][nx].type = ".";
                map[ny][nx].time = 0;
            }
        }
    }

    static boolean checkRange(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < r && nx < c;
    }
}
