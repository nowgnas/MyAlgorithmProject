package mystudy.fortest;

import java.util.Arrays;

class CombTest {

    static int pick, n;
    static int[] arr, numbers;

    public static void main(String[] args) {
        arr = new int[]{1, 2, 3, 4, 5};

        n = arr.length;
        pick = 3;
        numbers = new int[pick];
        comb(0, 0);

    }

    static void comb(int cnt, int start) {
        if (cnt == pick) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = start; i < n; i++) {
            numbers[cnt] = arr[i];
            comb(cnt + 1, i + 1);
        }

    }


}