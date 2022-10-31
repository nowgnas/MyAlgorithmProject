package study.week12.카드섞기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[] p, s, defaultArray, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        defaultArray = new int[n];
        temp = new int[n];

        for (int i = 0; i < n; i++) {
            defaultArray[i] = i % 3;
        }

        // 어느 플레이어한테 가야 하는지
        p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 카드를 섞는 방법
        s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int res = 0;
        int cnt = 0;
        int nonFlag = 0;

        while (true) {
            // 카드 비교하기
            for (int i = 0; i < n; i++) {
                if (defaultArray[i] == i) {
                    nonFlag++;
                }
                if (defaultArray[i] == p[i]) {
                    cnt++;
                } else {
                    cnt = 0;
                    break;
                }
            }
            if (nonFlag == n) {
                System.out.println(-1);
                break;
            }
            if (cnt == n) {
                System.out.println(res);
                break;
            }

            // 카드 섞기
            for (int i = 0; i < n; i++) {
                temp[i] = defaultArray[s[i]];
            }
            // 카드 배열 복사 하기
            for (int i = 0; i < n; i++) {
                defaultArray[i] = temp[i];
            }
            res++;
        }
    }
}
