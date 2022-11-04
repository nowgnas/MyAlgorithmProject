package study.week12.소문난칠공주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n = 5;
    static String res;
    static char[][] map;
    static int[] numbers;

    static class node {
        int y, x;

        public node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[n][n];
        numbers = new int[25];

        int idx = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        } // 입력 끝


    }

    static void comb(int start, int cnt) {
        if (cnt == 7) {
            return;
        }
        for (int i = 0; i < 25; i++) {
            numbers[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }


}
