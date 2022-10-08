package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P041_BJ1992_쿼드트리 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] board;
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count += board[i][j];
            }
        }
        if (count == n * n) {
            sb.append(1);
        } else if (count == 0) {
            sb.append(0);
        } else {
            solve(n / 2, 0, 0);
        }
        System.out.println(sb);

    }

    private static void solve(int size, int y, int x) {

        sb.append("(");
        // 왼쪽 위
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i + y][j + x] == 1) {
                    count += 1;
                }
            }
        }
        if (count == size * size) {
            sb.append(1);
        } else if (count == 0) {
            sb.append(0);
        } else {
            solve(size / 2, y, x);
        }
        // 오른쪽 위
        count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i + y][j + x + size] == 1) {
                    count += 1;
                }
            }
        }
        if (count == size * size) {
            sb.append(1);

        } else if (count == 0) {
            sb.append(0);

        } else {
            solve(size / 2, y, x + size);
        }
        // 왼쪽 밑
        count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i + size + y][j + x] == 1) {
                    count += 1;
                }
            }
        }
        if (count == size * size) {
            sb.append(1);
        } else if (count == 0) {
            sb.append(0);
        } else {
            solve(size / 2, y + size, x);
        }
        // 오른쪽 밑
        count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i + size + y][j + size + x] == 1) {
                    count += 1;
                }
            }
        }
        if (count == size * size) {
            sb.append(1);

        } else if (count == 0) {
            sb.append(0);

        } else {
            solve(size / 2, y + size, x + size);
        }
        sb.append(")");
    }
}
