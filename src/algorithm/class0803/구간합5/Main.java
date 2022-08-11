package algorithm.class0803.구간합5;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n + 1][n + 1];
        int[][] arr2 = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int num = sc.nextInt();
                arr2[i][j] = num;
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j] + num - arr[i - 1][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            sb.append(arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1]).append("\n");
        }
        System.out.print(sb);

    }
}
