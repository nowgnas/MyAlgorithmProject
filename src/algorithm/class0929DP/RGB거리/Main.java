package algorithm.class0929DP.RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[][] map;
    static int[] result;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        result = new int[3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 3; i++) {
            result[i] += map[0][i];
            selectColor(i, i, 1);
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < result.length; i++) {
            answer = Math.min(answer, result[i]);
        }
        System.out.println(answer);

    }
    static void selectColor(int nowidx, int idx, int row){
        int minVal = Integer.MAX_VALUE;
        int newIdx = 0;
        for (int i = 0; i < 3; i++) {
            if (minVal > map[row][i] && idx != i) {
                minVal = map[row][i];
                newIdx = i;
            }
        }
        result[nowidx] += minVal;
        if (row == n - 1) return;
        selectColor(nowidx, newIdx, row + 1);
    }
}