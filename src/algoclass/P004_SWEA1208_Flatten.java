package 이상원;

import java.util.Arrays;
import java.util.Scanner;

public class P004_SWEA1208_Flatten {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int dump = sc.nextInt();
            int[] arr = new int[100];
            for (int j = 0; j < 100; j++) {
                arr[j] = sc.nextInt();
            }
            // 알고리즘 시작
            int result = 0;
            Arrays.sort(arr);
            for (int j = 0; j < dump; j++) {

                if (arr[arr.length - 1] - arr[0] <= 1) {
                    result = arr[arr.length - 1] - arr[0];
                    break;
                }
                arr[0]++;
                arr[arr.length - 1]--;
                Arrays.sort(arr);
                result = arr[arr.length - 1] - arr[0];
            }
            System.out.println("#" + (i + 1) + " " + result);
        }
    }
}
