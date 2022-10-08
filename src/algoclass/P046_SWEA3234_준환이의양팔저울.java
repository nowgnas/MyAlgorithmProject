package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P046_SWEA3234_준환이의양팔저울 {
    static int n, res;
    static int[] weight, arr;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            // test case 만큼 돌기
            n = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            visited = new boolean[n];
            weight = new int[n];

            perm(0);
            System.out.println("#" + tc + " " + res);
        }

    }

    static void perm(int cnt) {
        if (cnt == n) {
            check(0, 0, 0);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            weight[cnt] = arr[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }

    static void check(int idx, int sumL, int sumR) {
        if (idx == n) {
            res++;
            return;
        }

        check(idx + 1, sumL + weight[idx], sumR);
        if (sumR + weight[idx] <= sumL) {
            check(idx + 1, sumL, sumR + weight[idx]);
        }
    }
}
