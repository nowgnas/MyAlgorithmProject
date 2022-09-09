package study.week6.YonseiTOTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int n, m, p, l;
    static int[] count;
    static Integer[] score;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        /*
         * 수강 신청이 마일리지 제도로 바꼈다
         * 듣고 싶은 과목에 마일리지를 과목당 1~36을 분배한다
         * 분배가 끝나면 과목에 대해 마일리지를 많이 투자한 순으로 과목의 수강 인원만큼 신청 된다
         */

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        count = new int[n];

        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            score = new Integer[p];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < p; i++) {
                score[i] = Integer.parseInt(st.nextToken());
            } // 입력 끝
            Arrays.sort(score, Collections.reverseOrder());
            solve(j, p, l, score);

        }

        Arrays.sort(count);
        int cnt = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            if (m < 0) break;
            m -= count[i];
            cnt++;
        }

        System.out.println(cnt);
    }

    static void solve(int j, int p, int l, Integer[] score) {
        /*
        * l이 */
        int idx = l > score.length ? score.length - 1 : l - 1;
        int cost = score[idx] < 36 ? score[idx] : 0;
        count[j] = cost;
    }
}
