package kang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다리놓기 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 조합 결국 M개 중에 N개를 선택하는 문제 ..
        int[][] dp = new int[31][31]; // 30개니까 ..
        for (int i = 0; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }
        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
        for (int i = 0; i < T; i++) { // 테스트케이스만큼 돌면서
            String s[] = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]); // 서쪽
            int M = Integer.parseInt(s[1]); // 동쪽

            sb.append(dp[M][N] + "\n");
        }
        System.out.println(sb);
    }
}