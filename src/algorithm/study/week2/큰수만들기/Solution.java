package algorithm.study.week2.큰수만들기;

import java.util.Arrays;

public class Solution {
    static int[] arr;
    static int maxVal;

    public static void main(String[] args) {
        String number = "654321";
        int k = 5;

        arr = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
        int maxLength = number.length();
        int numLength = maxLength - k; // 만들 숫자 길이
        boolean[] visit = new boolean[maxLength];
        maxVal = Integer.MIN_VALUE;
        comb(arr, visit, 0, numLength);
        System.out.println(Integer.toString(maxVal));

    }

    private static void comb(int[] nums, boolean[] visit, int depth, int r) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                if (visit[i]) sb.append(nums[i]);
            }
            int value = Integer.parseInt(String.valueOf(sb));
            if (maxVal < value) maxVal = value;
            return;
        }
        if (depth == nums.length) return;
        else {
            visit[depth] = true;
            comb(nums, visit, depth + 1, r - 1);

            visit[depth] = false;
            comb(nums, visit, depth + 1, r);
        }
    }
}
