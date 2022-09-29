package com.jurib.live08.class0929DP.최소동전개수;

import java.util.Scanner;

public class 최소동전개수2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int[] D = new int[money + 1]; // D[i] i 금액을 만드는 최소 동전 수
        int INF = 100000;
        D[0] = 0;
        for (int i = 1; i <= money; ++i) {
            int min = INF;
            if (i >= 4) min = Math.min(min, D[i - 4] + 1);
            if (i >= 6) min = Math.min(min, D[i - 6] + 1);
            D[i] = min;
        }
        System.out.println(D[money]);
        System.out.println(D[money] == INF ? -1 : D[money]);
    }
}
