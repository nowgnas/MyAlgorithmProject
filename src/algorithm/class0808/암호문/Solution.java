package algorithm.class0808.암호문;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10; // 테스트케이스
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            List<String> code = new ArrayList<String>();
            // 원본 암호문의 길이 10 <= N <= 20
            int N = Integer.parseInt(br.readLine());

            // 원본 암호문 읽고
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 암호 리스트에 넣기
            for (int i = 0; i < N; i++) {
                code.add(st.nextToken());
            }
            // 명령어의 개수 5 <= N <= 10
            int k = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                String command = st.nextToken(); // |
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // y개 넣기
                for (int j = 0; j < y; j++) {
                    code.add(x + j, st.nextToken());
                }
            }

            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(code.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}