package 이상원;

import java.util.Scanner;

public class DP_최소동전개수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int[] D = new int[money + 1];
        int min;
        for (int i = 1; i <= money; ++i) {
            min = Integer.MAX_VALUE;
            min = Math.min(min, D[i - 1] + 1);
            if (i >= 4) min = Math.min(min, D[i - 4] + 1);
            if (i >= 6) min = Math.min(min, D[i - 6] + 1);

            D[i] = min;
        }
        System.out.println(D[money]);
    }


}
