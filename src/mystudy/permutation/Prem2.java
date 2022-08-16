package mystudy.permutation;

import java.util.Arrays;

public class Prem2 {
    static int n, r, totalCount;
    static int[] numbers, input;
    static boolean[] isSelected;

    // nPr : 1부터 n까지의 수 중 n개를 모두 뽑아 순서적으로 나열한 것
    public static void main(String[] args) {
        n = 3;
        r = 3;
        totalCount = 0;
        input = new int[n];
        numbers = new int[r];
        isSelected = new boolean[n];
        for (int i = 0; i < n; i++) {
            input[i] = i + 1;
        }
        perm(0);
    }

    private static void perm(int cnt) { // cnt+1 번째 해당하는 수를 뽑기
        if (cnt == r) {
            totalCount++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        // 가능한 모든 수에 대해 시도
        for (int i = 0; i < n; i++) {
            // 시도하는 수가 선택되었는지 판단
            if (isSelected[i]) continue;
            // 선택되지 않았다면 수를 사용
            numbers[cnt] = input[i];
            isSelected[i] = true;
            // 다음 수 뽑으러 가기
            perm(cnt + 1);
            // 사용했던 수에 대해 선택을 되돌려 놓기
            isSelected[i] = false;
        }
    }
}
