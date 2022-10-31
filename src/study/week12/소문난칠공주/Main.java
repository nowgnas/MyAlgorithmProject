package study.week12.소문난칠공주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n = 5;
    static String res;
    static char[][] map;
    static node[] tmp, nodeArr;
    static boolean[] visited;

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
        tmp = new node[7];
        nodeArr = new node[n * n];
        visited = new boolean[n * n];

        int idx = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                nodeArr[idx] = new node(i, j);
                idx++;
            }
        } // 입력 끝
        perm(0);


    }

    static void perm(int cnt) {
        // y가 4개이면 break
        if (cnt == 7) {
            System.out.println(Arrays.toString(tmp));
            return;
        }

        for (int i = 0; i < 7; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            tmp[cnt] = nodeArr[i];
            perm(cnt + 1);
            visited[i] = false;
        }


    }
}
