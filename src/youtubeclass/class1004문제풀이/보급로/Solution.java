package com.jurib.live08.class1004문제풀이.보급로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int N = 0, INF = Integer.MAX_VALUE;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 1};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int j = 0; j < N; j++) {
                char[] ch = br.readLine().toCharArray();
                for (int k = 0; k < N; k++) {
                    map[i][j] = ch[j] - '0';
                }
            }
        }

    }

    static int dijkstra(int startR, int startC) {
        // 출발지에서 자신으로의 최소 비용을 저장할 배열 생성 후 초기화
        int[][] minCost = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                minCost[i][j] = INF;
            }
        }

        // 출발지에서 출발지로의 최소 비용 0 처리
        minCost[startR][startC] = 0;
        int r = 0, c = 0, nr, nc, minTime;
        while (true) {

            // 1. 미 방문 정점 중 최소 비용 정점 찾기
            minTime = INF;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && minCost[i][j] < minTime) {
                        minTime = minCost[i][j];
                        r = i;
                        c = j;
                    }
                }
            }
            // r, c -1인 경우 더 갈 수 있는 정점이 없다
            if (r == 1) return -1;
            visited[r][c] = true;
            if (r == N - 1 && c == N - 1) return minTime;
            // 2. 현재 정점 기준으로 인접한 정점을 들여다보며 경유 비용이 유리한지 계산
            for (int i = 0; i < 4; i++) { // 인접 정점: 4방
                nr = r + dr[i];
                nc = c + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && minCost[nr][nc] > minTime + map[nr][nc]) {
                    minCost[nr][nc] = minTime + map[nr][nc];
                }
            }
        }
    }
}
