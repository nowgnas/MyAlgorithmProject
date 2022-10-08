package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* P023_SWEA1861_정사각형방
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc
* */
public class P023_SWEA1861_정사각형방 {
    static int n, tc, minStartValue, maxCnt, maxVal, nx, ny, cnt;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        tc = Integer.parseInt(br.readLine());

        maxCnt = Integer.MIN_VALUE;
        minStartValue = Integer.MAX_VALUE;

        for (int i = 1; i <= tc; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            minStartValue = Integer.MAX_VALUE;
            maxCnt = Integer.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                    if (maxVal < map[j][k]) maxVal = map[j][k];
                }
            }

            // dfs 돌리기
            cnt = 1;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dfs(j, k, 1, map[j][k]);
                }
            }
            sb.append("#").append(i).append(" ").append(minStartValue).append(" ").append(maxCnt);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int x, int y, int cnt, int start) {
        for (int i = 0; i < 4; i++) {
            nx = dx[i] + x;
            ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[nx][ny] - map[x][y] == 1) {
                    dfs(nx, ny, cnt + 1, start);
                }
            }
        }
        if (cnt > maxCnt) {
            maxCnt = cnt;
            minStartValue = start;
        } else if (cnt == maxCnt) {
            minStartValue = Math.min(start, minStartValue);
        }
    }
}
