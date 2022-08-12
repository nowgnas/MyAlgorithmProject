package algorithm.class0811.백설공주와일곱난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr = new int[9];
    static int x, y;

    public static void main(String[] args) throws IOException {
        // 7개가 100
        // 9개를 다 더하고 2개씩 짝지었을때 총합에서 - 2개 짝지은걸 = 100
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int sum = Arrays.stream(arr).sum();
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - (arr[i] + arr[j]) == 100) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i == x | i == y) {
                continue;
            } else {
                System.out.println(arr[i]);
            }
        }
    }
}
