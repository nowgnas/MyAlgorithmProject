package mystudy.permutation;

import java.util.Arrays;

public class Perm {
    static int n, r, totalCount;
    static int[] numbers;
    static boolean[] isSelected;

    // nPn : 1부터 n까지의 수 중 n개를 모두 뽑아 순서적으로 나열한 것
    public static void main(String[] args) {
        n = 3;
        r = 2;
        totalCount = 0;
        numbers = new int[r];
        isSelected = new boolean[n + 1];

        perm(0);
    }

    private static void perm(int cnt) { // cnt+1 번째 해당하는 수를 뽑기
        if (cnt == r) {
            totalCount++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        // 가능한 모든 수에 대해 시도
        for (int i = 1; i <= n; i++) {
            // 시도하는 수가 선택되었는지 판단
            if (isSelected[i]) continue;
            // 선택되지 않았다면 수를 사용
            numbers[cnt] = i;
            isSelected[i] = true;
            // 다음 수 뽑으러 가기
            perm(cnt + 1);
            // 사용했던 수에 대해 선택을 되돌려 놓기
            isSelected[i] = false;
        }
    }
}
