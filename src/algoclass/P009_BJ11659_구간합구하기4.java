package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P009_BJ11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] savedSum = new int[nums[0] + 1];
        for (int i = 0; i < arr.length; i++) {
            savedSum[i + 1] += savedSum[i] + arr[i];
        }
        for (int i = 0; i < nums[1]; i++) {
            int[] startEnd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(savedSum[startEnd[1]] - savedSum[startEnd[0] - 1]).append("\n");
        }
        System.out.print(sb);


    }
}
