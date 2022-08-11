package algorithm.class0802.사다리;

import java.util.Scanner;

/*
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh
*/
public class Solution {
    public static void main(String[] args) {
        int[] dx = {0, 0, -1};
        int[] dy = {-1, 1, 0};
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
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
            // 3 방향 확인 - 위, 좌, 우
            // 시작 99,99
            while (x != 0) {
                for (int l = 0; l < 3; l++) {
                    int nx = dx[i] + x;
                    int ny = dy[i] + y;
                    if (ny < ladder.length) {
                        // 테이블 안쪽일 때
                        if (ladder[nx][ny] == 1) {
                            x = nx;
                            y = ny;
                            ladder[x][y] = 2;
                            break;
                        }
                    }
                }
            }
            sb.append("#").append(tn).append(" ").append(y);
        }
        System.out.print(sb);
    }
}
