package ssafy보충.알고리즘.숫자만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeRZV6kBUDFAVH&categoryId=AWIeRZV6kBUDFAVH&categoryType=CODE&problemTitle=4008&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
*/
public class Solution {
    static int tc, n, resultMax, resultMin;
    static List<Integer> calculate;
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
            calculate = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int value = Integer.parseInt(st.nextToken());
                for (int k = 0; k < value; k++) {
                    calculate.add(j);
                }
            } // 연산자 개수
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            } // 주어진 숫자

            resultMax = Integer.MIN_VALUE;
            resultMin = Integer.MAX_VALUE;

            perm(0, calculate);
            System.out.println("#" + i + " " + (resultMax - resultMin));

        }

    }

    static void perm(int cnt, List<Integer> calculate) {
        if (cnt == n - 1) {
            int val = num[0];
            for (int i = 1; i < num.length; i++) {
                val = calNum(val, num[i], newArr[i - 1]);
            }
            resultMax = Math.max(resultMax, val);
            resultMin = Math.min(resultMin, val);
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (visited[i]) continue;
            newArr[cnt] = calculate.get(i);
            visited[i] = true;
            perm(cnt + 1, calculate);
            visited[i] = false;
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
