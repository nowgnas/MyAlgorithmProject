package mystudy.순조부외우기;

import java.util.Arrays;

public class Combination {

    static int[] inputs;
    static int[] numSet;
    static int N, R;

    public static void main(String[] args) {
        N = 10;
        R = 4;
        inputs = new int[N];
        numSet = new int[R];

        for (int i = 0; i < N; i++) {
            inputs[i] = i + 1;
        }
        comb(0, 0);


    }

    static void comb(int cnt, int start) {
        if (cnt == R) {
            System.out.println(Arrays.toString(numSet));
            return;
        }

        for (int i = start; i < N; i++) {
            numSet[cnt] = inputs[i];
            comb(cnt + 1, i + 1);
        }
    }
}
