package algorithm.class0808.한빈이와SportMart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
*  :gift:   :gift:  과제
P020_SWEA9229_한빈이와SpotMart
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN

* */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 과자 봉지 개수
            int m = Integer.parseInt(st.nextToken()); // 무게 합 제한

            List<Integer> weight = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                weight.add(Integer.parseInt(st.nextToken()));
            }
            int maxNum = 0;
            for (int j = 0; j < n - 1; j++) {
                for (int k = 1; k < n; k++) {
                    int sum = weight.get(j) + weight.get(k);
                    if (maxNum < sum && m >= sum) {
                        maxNum = sum;
                    }
                }
            }
            if (maxNum == 0) maxNum = -1;
            sb.append("#").append(i).append(" ").append(maxNum);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
