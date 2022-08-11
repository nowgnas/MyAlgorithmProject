package algorithm.class0802.suzy;

import java.util.Scanner;

public class P005_SWEA1210_Ladder1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 100; // 100*100 2차원 배열을 주기위해

        for (int tc = 1; tc <= 10; tc++) {

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            } // 입력 완료 !

            int ans = 0;
            // 거꾸로 올라가기 ..
            for (int i = 99; i >= 0; i--) {
                for (int j = 0; j < 100; j++) {
                    if (map[i][j] == 2) { // 도착지점

                        int d = 1; // 방향 때문에 ..
                        if (i + d >= 0 && i + d < 100 && i - d >= 0 && i - d < 100) {
                            if (map[i + d][j] == 0 && map[i - d][j] == 0) { // 양옆이 0이면
                                for (int k = j; k > 0; k--) {
                                    map[i][k] = map[i][k - d]; // 위로 올라가 !
                                }
                                if (map[i][j - d] == 0) {
                                    break;
                                }
                            } else if (map[i + d][j] == 1) { // 만약 오른쪽으로 가면 ?
                                for (int k = i + d; k < N; k++) { // 오른쪽으로 끝까지 가는데
                                    if (map[k][j] == 0) {
                                        break;
                                    }
                                }
                            } else if (map[i - d][j] == 1) { // 왼쪽으로 가면 ?!
                                for (int k = j; k > 0; k--) {
                                    if (map[k][j] == 0) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
//					 // 만약 0 행의 1을 만나는 순간 ... !
                }
            } // 배열 다 돌기 ..
            System.out.printf("#%d %d\n", tc, ans);
        }

    }


}
