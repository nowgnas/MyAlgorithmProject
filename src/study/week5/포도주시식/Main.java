package study.week5.포도주시식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static BufferedReader br;
    static StringTokenizer st;
    static int[] cup;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        /*
         * 잔에 있는거 모두 마셔야 되고
         * 연속으로 3잔은 마실 수 없음
         */
        cup = new int[n];

        for (int i = 0; i < n; i++) {
            cup[i] = Integer.parseInt(br.readLine());
        }

        int[] d = new int[n + 2];
        d[1] = cup[0];
        d[2] = d[1] + cup[1];

        for (int i = 3; i <= n; i++) {
            d[i] = Math.max(d[i - 3] + cup[i - 1] + cup[i - 2], d[i - 2] + cup[i - 1]);
            d[i] = Math.max(d[i], d[i - 1]);
        }

        System.out.println(d[n]);

    }
}
