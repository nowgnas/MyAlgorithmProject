package study.week4.팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] alpha = new int[26];

        for (char str :
                s.toCharArray()) {
            alpha[str - 'A']++;
        } // 글자 개수 카운트

        int n = 0;
        int mid = 0;
        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 == 1) {
                mid = i;
                n++;
            }
        }// 홀수면 가운데 넣기

        StringBuilder sb = new StringBuilder();
        if ((s.length() % 2 == 1 && n > 1) || (s.length() % 2 == 0 && n > 0)) {
            sb.append("I'm Sorry Hansoo");
        } else {
            String answer = "";
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alpha[i] / 2; j++) {
                    answer += (char) (i + 'A');
                }
            }
            String revers = new StringBuilder(answer).reverse().toString(); // 뒤집어 준다
            if (n == 1) {
                answer += (char) (mid + 'A');
            }
            sb.append(answer + revers);
        }
        System.out.print(sb);
    }
}
