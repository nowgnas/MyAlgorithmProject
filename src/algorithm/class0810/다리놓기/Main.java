package algorithm.class0810.다리놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m;
    static long[][] dp;


    public static void main(String[] args) throws IOException {

        int testcase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testcase; t++) {
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = array[0];
            m = array[1];
            dp = new long[m + 1][m + 1];
            // dp[i][j] = iCj 이항 계수 공식 = dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
            // dp[i][i] = 전체 중에 전체를 꺼내는 경우 = 1
            // dp[i][0] = 아예 안꺼내는 경우 = 1
            for (int i = 0; i < m; i++) {
                dp[i][i] = 1;
                dp[i][0] = 1;
            }
            dp[1][1] = 1;

            for (int i = 2; i < m + 1; i++) {
                dp[i][1] = i;
                for (int j = 1; j < n + 1; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
            System.out.println(dp[m][n]);
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}


/*

3
2 2
1 5
13 29

*/