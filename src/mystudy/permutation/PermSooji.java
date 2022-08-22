package mystudy.permutation;

import java.io.InputStreamReader;
import java.util.Scanner;

public class PermSooji {
    static int n, r;
    static int[] input, numbers;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        n = sc.nextInt(); // 서로 다른 n 개를 입력받아서
        r = sc.nextInt(); // 순서를 고려하여 r 개를 고르는 순열 !

        input = new int[n];
        numbers = new int[r];

        isSelected = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        } // 입력 완료

        perm(0);
    }

    private static void perm(int cnt) {
        if (cnt == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isSelected[i]) {
                // 사용되지 않는 수면 사용
                numbers[cnt] = input[i];
                isSelected[i] = true;

                perm(cnt + 1); // 다음 자리수로 넘어감
                isSelected[i] = false; // 다음 사용을 위해
            }
        }
    }

}