package study.week8.지구온난화;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static int[][] map;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r + 2][c + 2];

        for (int i = 1; i <= r; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j <= c; j++) {
                if (line[j - 1] == 'X') {
                    map[i][j] = 1;
                }
            }
        }// 입력 완료
        String[] result = new String[r + 2];

        for (int i = 1; i <= r; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= c; j++) {
                if (map[i][j] == 1) {
                    if (check(i, j)) sb.append(0);
                    else sb.append(1);
                } else {
                    sb.append(0);
                }
            }
            result[i] = sb.toString();
        }

        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int i = 1; i <= r; i++) {
            if (result[i].contains("1")) {
                for (int j = 0; j < c; j++) {
                    if (result[i].charAt(j) == '1') {
                        minY = Math.min(minY, i);
                        minX = Math.min(minX, j);
                        maxY = Math.max(maxY, i);
                        maxX = Math.max(maxX, j);
                    }
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                answer.append(result[i].charAt(j) == '1' ? "X" : ".");
            }
            answer.append("\n");
        }
        System.out.print(answer.toString());


    }

    static boolean check(int y, int x) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + direction[i][0];
            int nx = x + direction[i][1];
            if (map[ny][nx] == 0) {
                cnt++;
            }
        }
        return cnt >= 3;
    }
}
