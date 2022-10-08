package 이상원;

import java.util.Scanner;

public class P005_SWEA1210_Ladder1 {
    static int[] dx = {0, 0, -1};
    static int[] dy = {-1, 1, 0};

    public static int findRoot(int[][] ladder, int x, int y) {
        // 3 방향 확인 - 위, 좌, 우
        // 시작 99,99
        while (true) {
            if (x == 0) {
                return y;
            }

            for (int i = 0; i < 3; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                // 3 방향 확인
                if (nx < 0 || nx >= ladder.length || ny < 0 || ny >= ladder.length) {
                    continue;
                }
                if (ladder[nx][ny] == 2) {
                    continue;
                }
                if (ladder[nx][ny] == 1) {
                    ladder[x][y] = 2;
                    x = nx;
                    y = ny;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Scanner sc = new Scanner(System.in);
            int tn = sc.nextInt();
            int[][] ladder = new int[100][100];
            int x = 0, y = 0;

            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    ladder[j][k] = sc.nextInt();
                    if (ladder[j][k] == 2) {
                        x = j;
                        y = k;
                    }
                }
            }
            int result = findRoot(ladder, x, y);
            System.out.println("#" + tn + " " + result);
        }
    }
}
