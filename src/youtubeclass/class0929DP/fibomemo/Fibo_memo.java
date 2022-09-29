package com.jurib.live08.class0929DP.fibomemo;

import java.util.Arrays;
import java.util.Scanner;

public class Fibo_memo {
    static long[] calls1, calls2, memo;
    static long callCnt1, callCnt2;
    static int N;

    static long fibo1(int n) { // 메모하지 않는 버전
        callCnt1++;
        calls1[n]++;

        if (n <= 1) return n; // 1항이면 1, 0항이면 0
        return fibo1(n - 1) + fibo1(n - 2);
    }

    static long fibo2(int n) { // 메모하는 버전
        callCnt2++;
        calls2[n]++;
        if (memo[n] == -1) { // 메모가 안되어 있는 상태
            memo[n] = fibo2(n - 1) + fibo2(n - 2); // 계산 후 메모
        }
        return memo[n]; // 메모된 값 리턴
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        calls1 = new long[N + 1]; // 각 항을 계산하기 위한 수행 횟수
        calls2 = new long[N + 1];


        callCnt1 = callCnt2 = 0; // 총 수행 횟수

        memo = new long[N + 1];
        Arrays.fill(memo, -1); // 메모 되지 않는 상태를 나타내는 값으로 -1 초기화
        // 처음부터 계산이 가능한 값 초기화
        memo[0] = 0;
        memo[1] = 1;

        System.out.println(fibo1(N));
        System.out.println(callCnt1);

        System.out.println("============================");
        System.out.println("ans: " + fibo1(N));
        for (int i = 1; i <= N; i++) {
            System.out.println("fibo1: " + i + " calls1: " + calls1[i]);
        }
        System.out.println("============================");

        System.out.println("============================");
        System.out.println("ans: " + fibo2(N));
        System.out.println(fibo2(N));
        System.out.println(callCnt2);

        for (int i = 1; i <= N; i++) {
            System.out.println("fibo2: " + i + " calls2: " + calls2[i]);
        }
        System.out.println("============================");
    }
}
