package study.week7.빙고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int n = 5;
    static BufferedReader br;
    static StringTokenizer st;
    static HashMap<Integer, Node> hashMap;
    static int[][] map;

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[n + 1][n + 1];
        hashMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                hashMap.put(val, new Node(i, j));
            }
        } // 빙고판 입력 완료

        /*
         * 숫자 하나 부를 때 마다 체크
         * 빙고가 되려면 5개가 되어야 하니까
         * 5개까지는 계속 추가
         * 3, 3에 채워지면 대각선 한번 확인
         * 추가 되면 가로 세로 확인
         */
        int bingo = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                count++;
                int call = Integer.parseInt(st.nextToken()); // 부른 숫자
                Node cur = hashMap.get(call);

                map[cur.y][cur.x] = 0;
                if (vertical(cur.y, cur.x)) bingo++;
                if (horizontal(cur.y, cur.x)) bingo++;
                if (cur.y == cur.x) {
                    if (digonal()) bingo++;
                }
                if (cur.y + cur.x == 6) {
                    if (digonalReverse()) bingo++;
                }
                if (bingo >= 3) {
                    System.out.println(count);
                    System.exit(0);
                }
            }
        }
    }

    static boolean vertical(int y, int x) {
        // 세로 확인
        for (int i = 1; i <= n; i++) {
            if (map[i][x] != 0) return false;
        }
        return true;
    }

    static boolean horizontal(int y, int x) {
        // 가로 확인
        for (int i = 1; i <= n; i++) {
            if (map[y][i] != 0) return false;
        }
        return true;
    }

    static boolean digonal() {
        for (int i = 1; i <= n; i++) {
            if (map[i][i] != 0) return false;
        }
        return true;
    }

    static boolean digonalReverse() {
        /*
         * 1 5
         * 2 4
         * 3 3
         * 4 2
         * 5 1
         */
        int x = 5;
        for (int i = 1; i <= n; i++) {
            if (map[i][x] != 0) return false;
            x--;
        }
        return true;
    }
}
