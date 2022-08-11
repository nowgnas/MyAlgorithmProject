package algorithm.class0809.사칙연산유효성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* P021_SWEA1233_사칙연산유효성검사
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV141176AIwCFAYD
* */
public class Solution {
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            int n = Integer.parseInt(br.readLine());

            int answer = 1;
            String check = "+-*/";
            for (int j = 0; j < n; j++) {
                String[] line = br.readLine().split(" ");
                if (line.length > 2 && !check.contains(line[1])) {
                    answer = 0;
                } else {
                    for (int k = 2; k < line.length; k++) {
                        if (check.contains(line[k])) answer = 0;
                    }
                }
            }
            sb.append("#").append(i).append(" ").append(answer);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
