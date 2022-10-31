package study.week11.봄버맨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main4 {
    static char map[][];
    static int r, c, n;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static Queue<Node> q = new LinkedList<>();
    static int bombtime[][];
    static int time = 1;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        n = Integer.parseInt(input[2]);

        map = new char[r][c];
        bombtime = new int[r][c];

        for (int i = 0; i < r; i++) {
            String t = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = t.charAt(j);
                if (map[i][j] == 'O') {
                    q.add(new Node(i, j));
                    bombtime[i][j] = 3;
                }
            }
        }


        while (time++ < n) {
            if (time % 2 == 0) {
                setbomb();
            } else {
                getbomb();
            }
        }

        print();
    }

    public static void getbomb() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (bombtime[i][j] == time) {
                    bomb(i, j);
                }
            }
        }
    }

    public static void bomb(int x, int y) {
        map[x][y] = '.';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isRange(nx, ny) && map[nx][ny] == 'O' && bombtime[nx][ny] != time) {
                bombtime[nx][ny] = 0;
                map[nx][ny] = '.';
            }
        }
    }


    public static void setbomb() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'O';
                    bombtime[i][j] = time + 3;
                }
            }
        }
    }

    public static void print() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j] + "");
            }
            System.out.println();
        }
    }

    public static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < r && y < c) {
            return true;
        }
        return false;
    }
}

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}