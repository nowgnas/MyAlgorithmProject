package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P072_BJ2239_스도쿠 {
    static int[][] map;
    static List<Node> list;

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = line.charAt(j) - '0';
                if (map[i][j] == 0) list.add(new Node(i, j));
            }
        }
        solve(0);
    }

    static void solve(int cnt) {
        if (list.size() == cnt) { // 모든 0을 확인 했을 때 정답 출력
            printAnswer();
            System.exit(0);
        }

        // list에 있는 0의 좌표
        int y = list.get(cnt).y;
        int x = list.get(cnt).x;

        boolean[] check = new boolean[10];

        for (int i = 0; i < 9; i++) {
            if (map[y][i] != 0) {
                check[map[y][i]] = true;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (map[i][x] != 0) {
                check[map[i][x]] = true;
            }
        }
        int startY = (y / 3) * 3;
        int startX = (x / 3) * 3;
        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                if (map[i][j] != 0) {
                    check[map[i][j]] = true;
                }
            }
        }

        for (int i = 1; i < 10; i++) {
            if (!check[i]) {
                map[y][x] = i;
                solve(cnt + 1);
                map[y][x] = 0;
            }
        }


    }

    static void printAnswer() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
