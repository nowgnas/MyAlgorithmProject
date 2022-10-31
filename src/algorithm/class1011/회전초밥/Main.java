package algorithm.class1011.회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, d, k, c, max = Integer.MIN_VALUE;
    static int[] check, sushi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 놓인 접시 수
        d = Integer.parseInt(st.nextToken()); // 초밥 가지 수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹은 접시
        c = Integer.parseInt(st.nextToken()); // 쿠폰

        sushi = new int[n];
        check = new int[d + 1];

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (check[sushi[i]] == 0) count++;
            check[sushi[i]]++;
        }

        max = count;
        int start = 1, end = k;
        while (true) {
            if (check[sushi[start - 1]] == 1) count--;
            check[sushi[start - 1]]--;

            if (check[sushi[end]] == 0) count++;
            check[sushi[end]]++;

            if (check[c] == 0) max = Math.max(max, count + 1);
            else max = Math.max(max, count);

            start++;
            end++;
            if (end == n) end = 0;
            if (start == n) break;
        }
        System.out.println(max);
    }
}
