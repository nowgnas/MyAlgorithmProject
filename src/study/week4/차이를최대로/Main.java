package study.week4.차이를최대로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, listSum, maxSum;
    static int[] line, numSet;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        visited = new boolean[N];
        numSet = new int[N];
        maxSum = Integer.MIN_VALUE;
        // abs(a0 - a1) + abs(a1 - a2) ... abs(a n-2 - a n-1) 을 구하라
        // 순열을 사용해야 할 거 같다
        perm(0);
        System.out.println(maxSum);


    }

    static void perm(int cnt) {
        if (cnt == N) {
            // 식을 구셩해야 함
            listSum = 0;
            for (int i = 0; i < N - 1; i++) {
                listSum += Math.abs(numSet[i] - numSet[i + 1]);
            }
            maxSum = Math.max(maxSum, listSum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                numSet[cnt] = line[i];
                visited[i] = true;

                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
