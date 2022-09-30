package algorithm.class0930.파이프옮기기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 집의 크기

        int[][] map = new int[N + 1][N + 1]; // 집의 상태
        for (int i = 1; i <= N; i++) {
            String s[] = bf.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(s[j - 1]);
            }
        } // 입력

        // dp 방향, 좌표
        int[][][] dp = new int[3][N + 1][N + 1];
        // 가로이면서 시작좌표를 넣고 ..
        dp[0][1][2] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 3; j <= N; j++) { // 시작 좌표부터 돌면서

                if (map[i][j] == 1) continue; // 벽인 경우

                // i 가 0 인 경우
                if (i == 1) dp[0][i][j] = dp[0][i][j - 1] + dp[2][i][j - 1];

                // 대각선인 경우 위쪽과 왼쪽이 모두 비어있어야한다
                if (map[i][j - 1] == 0 && map[i - 1][j] == 0)
                    dp[2][i][j] = dp[2][i - 1][j - 1] + dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1];

                // 가로인 경우 : 가로, 대각선
                dp[0][i][j] = dp[0][i][j - 1] + dp[2][i][j - 1];

                // 세로인 경우 : 세로, 대각선
                dp[1][i][j] = dp[1][i - 1][j] + dp[2][i - 1][j];

            }
        }

        System.out.println(dp[0][N][N] + dp[1][N][N] + dp[2][N][N]);

    } // main end
}