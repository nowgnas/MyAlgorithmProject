package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P029_SWEA5215_햄버거다이어트 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int l;
    static int[] comb;
    static int[] visit;

    static int[][] hamburger;
    static int answer;

    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testcase; t++) {
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = array[0];
            l = array[1];
            answer = 0;
            visit = new int[n];
            comb = new int[n];
            hamburger = new int[n][];
            for (int i = 0; i < n; i++) {
                hamburger[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            solve(0, 0, 0);
            System.out.printf("#%d %d\n", t + 1, answer);
        }
    }

    // 총 경우의 수가 2^n -1
    static void solve(int count, int point, int calories) { // 백트래킹
        // 종료조건
        if (calories <= l) {
            answer = Math.max(point, answer);
        }

        if (count >= n || calories > l) {
            return;
        }

        // 현재 재료를 사용
        solve(count + 1, point + hamburger[count][0], calories + hamburger[count][1]);

        // 현재 자료를 사용하지않고 건너뜀
        solve(count + 1, point, calories);
    }


}
