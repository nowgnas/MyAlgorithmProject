package algorithm.class0929DP.RGB거리;

import java.io.IOException;
import java.util.Scanner;

public class P065_BJ1149_RGB거리 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 집의 수

        int[][] cost = new int[N][3]; // R: 0, G: 1, B: 2
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = sc.nextInt();
            }
        } // 입력 완료

        // 이전의 서로 다른 색깔의 집 (칠하려는 색과 다른 .. ) + 현재 칠하려는 색
        for (int i = 1; i < N; i++) {
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]);
            System.out.println(cost[i][0] + " " + cost[i][1] + " " + cost[i][2]);
        }

        System.out.println(Math.min(Math.min(cost[N - 1][0], cost[N - 1][1]), cost[N - 1][2]));
    }

}
