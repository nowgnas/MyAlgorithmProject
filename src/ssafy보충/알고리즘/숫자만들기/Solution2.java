package ssafy보충.알고리즘.숫자만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
    static int tc, n, resultMax, resultMin;
    static int[] calculate;
    static BufferedReader br;
    static boolean[] visited;
    static int[] newArr;
    static StringTokenizer st;
    static int[] num;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            n = Integer.parseInt(br.readLine());
            num = new int[n];
            visited = new boolean[n - 1];
            newArr = new int[n - 1];
            calculate = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                calculate[j] = Integer.parseInt(st.nextToken());
            } // 연산자 개수
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            } // 주어진 숫자

            resultMax = Integer.MIN_VALUE;
            resultMin = Integer.MAX_VALUE;

            perm(0);
            System.out.println("#" + i + " " + (resultMax - resultMin));

        }

    }

    static void perm(int cnt) {
        if (cnt == n - 1) {
            int val = num[0];
            for (int i = 1; i < num.length; i++) {
                val = calNum(val, num[i], newArr[i - 1]);
            }
            resultMax = Math.max(resultMax, val);
            resultMin = Math.min(resultMin, val);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (calculate[i] > 0) {
                calculate[i]--;
                newArr[cnt] = i;
                perm(cnt + 1);
                calculate[i]++;
            }
        }
    }

    static int calNum(int a, int b, int command) {
        if (command == 0) {
            // +
            return a + b;
        } else if (command == 1) {
            // -
            return a - b;
        } else if (command == 2) {
            // *
            return a * b;
        } else {
            // /
            return a / b;
        }
    }
}
