package 이상원;

import java.util.Scanner;

public class P011_SWEA2001_파리퇴치 {
    public static int solution(int n, int m, int[][] arr) {
        int maxNum = 0;
        for (int i = 0; i < n - m + 1; i++) {
            for (int j = 0; j < n - m + 1; j++) {
                int eachSum = 0;
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < m; l++) {
                        eachSum += arr[i + k][j + l];
                    }
                }
                maxNum = Math.max(eachSum, maxNum);
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            // test case start
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            int maxNum = solution(n, m, arr);
            sb.append("#").append((i + 1)).append(" ").append(maxNum);
            // print
            System.out.print(sb);
        }
    }

}
