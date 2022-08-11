package algorithm.class0809.색종이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* P024_BJ2563_색종이
https://www.acmicpc.net/problem/2563
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] table = new int[101][101];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            for (int j = first; j < first + 10; j++) {
                for (int k = second; k < second + 10; k++) {
                    if (table[j][k] == 1)
                        continue;
                    table[j][k] = 1;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
