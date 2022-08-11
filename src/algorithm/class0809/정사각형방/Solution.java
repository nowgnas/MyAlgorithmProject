package algorithm.class0809.정사각형방;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* P023_SWEA1861_정사각형방
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc
*
값이 작은거 부터 탐색을 하자
* */
public class Solution {
    static int t, n;
    static int[][] arr;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int answer;
    static int visit;
    static int dot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            visit = 0;
            dot = Integer.MAX_VALUE;

            // 테스트 입력 끝
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int cnt = bfs(j, k, 1);
                    if (visit < cnt) {
                        visit = cnt;
                        dot = arr[j][k];
                    } else if (visit == cnt) {
                        dot = Math.min(dot, arr[j][k]);
                    }
                }
            }
            sb.append("#").append(i).append(" ").append(dot).append(" ").append(visit);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int x, int y, int cnt) {
        // 4방향을 봐야 한다
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            // table 안인 경우만
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (arr[nx][ny] - arr[x][y] == 1) {
                    x = nx;
                    y = ny;
                    cnt++;
                    bfs(x, y, cnt);
                }
            }
        }
        return cnt;
    }
}
