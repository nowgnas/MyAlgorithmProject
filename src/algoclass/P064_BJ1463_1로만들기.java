package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P064_BJ1463_1로만들기 {
    static BufferedReader br;
    static int n;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] dp = new int[1000001];
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        System.out.println(dp[n]);

    }
}
