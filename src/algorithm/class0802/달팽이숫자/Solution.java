package algorithm.class0802.달팽이숫자;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {

            int N = sc.nextInt();
            int[][] map = new int[N][N];
            int num = 1;
            int idx = 0; // 시작점

            // 우하좌상 .. 순서로 돌아감
            while (true) { // 반복 ... 탈출 잘하자 ...


                for (int j = idx; j < N - idx; j++) { // 먼저 우측 방향으로  ..
                    map[idx][j] = num;
                    num++;
                }

                // 아래 방향 !
                for (int i = 1 + idx; i < N - idx; i++) {
                    map[i][N - 1 - idx] = num;
                    num++;
                }
                // 좌측 방향
                for (int j = N - 1 - idx; j > idx; j--) {
                    map[N - 1 - idx][j - 1] = num;
                    num++;
                }
                // 위쪽 방향
                for (int i = N - 2 - idx; i > idx; i--) {
                    map[i][idx] = num;
                    num++;
                }

                idx++;    //idx=1
                if (num - 1 == N * N) {
                    break;
                }
            }
            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();

            }

        }
        sc.close();

    }
}
