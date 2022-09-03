package study.week5.이친수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long d[] = new long[N + 1];
        // d[n] = n자리 이친수.
        d[0] = 0;
        d[1] = 1;
        for (int i = 2; i <= N; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        System.out.println(Arrays.toString(d));
        System.out.println(d[N]);

    }
// 블로그 참고: https://odysseyj.tistory.com/25
}
