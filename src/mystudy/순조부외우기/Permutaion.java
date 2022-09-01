package mystudy.순조부외우기;

import java.util.Arrays;

public class Permutaion {
    static int[] inputs, numSet;
    static boolean[] visited;
    static int N, R;

    public static void main(String[] args) {
        N = 5;

        inputs = new int[N];
        visited = new boolean[N];
        numSet = new int[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = i + 1;
        }

        perm(0);


    }

    static void perm(int cnt) {
        if (cnt == N) {
            System.out.println(Arrays.toString(numSet));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            numSet[cnt] = inputs[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}
