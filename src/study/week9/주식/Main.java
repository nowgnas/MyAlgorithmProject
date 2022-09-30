package study.week9.주식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int t;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int sell = Integer.MIN_VALUE;
            long answer = 0;
            // 뒤에서 부터 보기
            for (int j = n - 1; j >= 0; j--) {
                if (sell < arr[j]) {
                    sell = arr[j];
                }
                if (sell > arr[j]) {
                    answer += sell - arr[j];
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
}
/*

3
4
2 2 1 3
5
1 2 3 1 3
10
1 2 5 4 3 7 6 5 9 8

*/