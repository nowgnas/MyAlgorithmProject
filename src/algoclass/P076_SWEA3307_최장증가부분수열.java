package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P076_SWEA3307_최장증가부분수열 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int k = 1; k <= n; k++) {
            int num = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] LIS = new int[num];

            int max = 0;
            for (int i = 0; i < num; i++) { // 앞쪽부터 모든 원소기준으로 자신을 끝으로 하는 LIS 계산
                LIS[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
                        LIS[i] = LIS[j] + 1;
                    }
                }
                max = Math.max(max, LIS[i]);
            }
            System.out.println("#" + k + " " + max);

        }

    }
}
