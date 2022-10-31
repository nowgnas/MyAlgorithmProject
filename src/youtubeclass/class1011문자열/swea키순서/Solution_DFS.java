package com.jurib.live08.class1011문자열.swea키순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_DFS {
    static int n;
    static int m, gtCnt, ltCnt;
    static int[][] adjmatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());

            adjmatrix = new int[n + 1][n + 1]; // 학생번호 1부터 처리
            StringTokenizer st = null;
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjmatrix[a][b] = 1; // a가 b보다 키가 크다
            }

            int answer = 0;
            for (int j = 1; j <= n; j++) {
                gtCnt = ltCnt = 0; // 초기화
                gtdfs(i, new boolean[n + 1]);
                ltdfs(i, new boolean[n + 1]);
                if (gtCnt + ltCnt == n - 1) answer++;
            }

            System.out.println(answer);

        }
    }

    static void gtdfs(int cur, boolean[] visited) { // start 학생부터 자신보다 키가 큰 학생따라 탐색
        visited[cur] = true;

        for (int i = 1; i <= n; i++) { // 자신의 인접행렬 들여다보기
            if (adjmatrix[cur][i] == 1 && !visited[i]) { // i가 cur보다 크고 아직 탐색되지 않았다면
                gtCnt++;
                gtdfs(i, visited);
            }

        }
    }

    static void ltdfs(int cur, boolean[] visited) { // start 학생부터 자신보다 키가 큰 학생따라 탐색
        visited[cur] = true;

        for (int i = 1; i <= n; i++) { // 자신의 인접행렬 들여다보기
            if (adjmatrix[i][cur] == 1 && !visited[i]) { // i가 cur보다 크고 아직 탐색되지 않았다면
                ltCnt++;
                ltdfs(i, visited);
            }

        }
    }


}
