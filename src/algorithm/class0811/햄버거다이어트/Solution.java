package algorithm.class0811.햄버거다이어트;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
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
            for (int i = 1; i <= n; i++) {
                combination(i, 0, 0, 0, 0);

            }
            System.out.printf("#%d %d", t + 1, answer);
        }
    }

    static void combination(int c, int count, int start, int point, int calories) {

        //조합의 개수가 전체를 넘어가면 종료
        if (count > c) {
            return;
        }

        if (calories > l) {
            return;
        }
        if (point > answer) {
            answer = point;
        }
        for (int i = start; i < n; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                combination(c, count + 1, start + 1, point + hamburger[i][0], calories + hamburger[i][1]);
                visit[i] = 0;
            }
        }

    }
}
