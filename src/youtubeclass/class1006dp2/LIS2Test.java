package com.jurib.live08.class1006dp2;

import java.util.Arrays;
import java.util.Scanner;

public class LIS2Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N]; // 수열의 수들
        int[] C = new int[N]; // 동적 테이블 C[k] : 해당 k 길이를 만족하는 자리에 오는 수의 최소값

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int size = 0;

        for (int i = 0; i < N; i++) {
            int pos = Arrays.binarySearch(C, 0, size, arr[i]);
            if (pos >= 0) continue;
            int insertPos = Math.abs(pos) - 1;
            C[insertPos] = arr[i];

            if (insertPos == size) size++;
        }
        System.out.println(size);

    }
}
