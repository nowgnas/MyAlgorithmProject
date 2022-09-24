package study.week7.퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, answer = Integer.MIN_VALUE;
    static int[][] day;
    static int[] idx;
    static boolean[] visited;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        day = new int[n + 1][2];
        idx = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if (i + t > n + 1) {
                p = 0; // 해당 날짜 + 소요 날짜가 N+1을 넘으면 불가능이므로 0
            }

            day[i][0] = t;
            day[i][1] = p;
        }

        comb(1); // 1일부터 시작
        System.out.println(answer);


    }

    static void comb(int cnt) {
        if (cnt >= n + 1) {
            int each = 0;
            for (int i = 1; i < visited.length; i++) {
                if (visited[i]) each += day[i][1];
            }
            answer = Math.max(answer, each);
            return;
        }

        visited[cnt] = true; // 현재 보는 날짜 true
        comb(cnt + day[cnt][0]); // 상담이 끝난 후 가능한 날짜로 재귀
        visited[cnt] = false; // 확인한 날은 false 처리
        comb(cnt + 1); // 다시 재귀로 확인
    }
}

/*

5
5 10
1 1
1 1
1 1
1 1

2
2 3
1 4

5
3 50
1 1
3 3
2 2
1 1

15
1 1
2 2
3 3
4 4
5 5
1 1
2 2
3 3
4 4
5 5
1 1
2 2
3 3
4 4
5 5

*/