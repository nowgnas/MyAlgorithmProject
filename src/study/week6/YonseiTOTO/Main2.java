package study.week6.YonseiTOTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2 {
    static int n, m, p, l;
    static int[] count;
    static Integer[] score;
    static BufferedReader br;
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        count = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            score = new Integer[p];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < p; j++) {
                score[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(score, Collections.reverseOrder());

            if (l > p) {
                count[i] = 1;
            } else {
                count[i] = score[l - 1];
            }
        }

        Arrays.sort(count);
        int cnt = 0;
        for (int i = 0; i < count.length; i++) {
            if (m >= count[i]) {
                m -= count[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
