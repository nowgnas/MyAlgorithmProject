package algorithm.youtubeclass.class0811.permutationbitmasking;

import java.util.Scanner;

public class BitMaskingTest {
    static int n, r, totalCount;
    static int[] numbers, input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();

        totalCount = 0;

        input = new int[n];
        numbers = new int[r];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        perm(0, 0);
    }

    public static void perm(int cnt, int flag) {
        if (cnt == r) {
            totalCount++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if ((flag & 1 << i) != 0) continue; // 사용중이라 continue
            numbers[cnt] = input[i];
            perm(cnt + 1, flag | 1 << i);
        }
    }
}
