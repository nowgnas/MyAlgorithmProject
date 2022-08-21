package study.week3.순위;

import java.util.Arrays;

public class Solution {
    //    https://easybrother0103.tistory.com/131
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int answer = 0;

        // 그래프 초기화
        int[][] floyd = new int[n + 1][n + 1];

        for (int i = 1; i < floyd.length; i++) {
            for (int j = 1; j < floyd.length; j++) {
                floyd[i][j] = 10000;
            }
        }

        for (int i = 0; i < results.length; i++) {
            int x = results[i][0];
            int y = results[i][1];

            floyd[x][y] = 1;
        }

        // 거쳐가는 정점
        for (int i = 1; i < floyd.length; i++) {
            // 시작 정점
            for (int j = 1; j < floyd.length; j++) {
                // 끝 정점
                for (int k = 1; k < floyd.length; k++) {
                    if (floyd[j][k] > floyd[j][i] + floyd[i][k]) {
                        floyd[j][k] = floyd[j][i] + floyd[i][k];
                    }
                }
            }
        }

        for (int i = 1; i < floyd.length; i++) {
            int count = 0;

            for (int j = 1; j < floyd.length; j++) {
                if (floyd[i][j] < 10000 || floyd[j][i] < 10000) {
                    count++;
                }
            }
            if (count == n - 1) answer++;
        }
        System.out.println(answer);
    }
}

/*
* 플로이드 워셜 알고리즘
* 주어진 간선 정보로 플로이드 워셜 맵 구성
* fw[i][j] 나 fw[j][i] 가 방문 가능이면 두 선수 실력을 가릴 수 있다 check
* check의 개수가 n-1 이면 모든 선수와 실력을 가릴 수 있다
* */