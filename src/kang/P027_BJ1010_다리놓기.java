package kang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P027_BJ1010_다리놓기 {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(100);

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
        for (int i = 0; i < T; i++) { // 테스트케이스만큼 돌면서
            String s[] = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]); // 서쪽
            int M = Integer.parseInt(s[1]); // 동쪽
            // 입력 --------------------------------


            // 조합 결국 M개 중에 N개를 선택하는 문제 ..
            long boonmo = 1l, boonja = 1l, result = 0;

            for (int j = M, k = N; k >= 1; j--, k--) {
                boonja *= j;
                boonmo *= k;
            }
            result = boonja / boonmo;
            System.out.println((int) result);

        }

    }

}