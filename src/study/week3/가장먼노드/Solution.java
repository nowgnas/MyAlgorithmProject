package study.week3.가장먼노드;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    static int cnt;

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        // n * n 테이블에 무향 그래프를 넣는다
        boolean[][] table = new boolean[ n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int[] ints : edge) {
            int start = ints[0];
            int end = ints[1];

            table[start][end] = table[end][start] = true; // 이 부분에서 1을 true로 바꿨는데 메모리 초과가 해결됨
        }
        cnt = bfs(table, visited);
        System.out.println(cnt);

    }

    static int bfs(boolean[][] table, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();

        visited[1] = true;
        queue.offer(1);
        int count = 0;

        while (!queue.isEmpty()) {
            count = queue.size();

            for (int i = 0; i < count; i++) {
                int cur = queue.poll();
                for (int j = 0; j < visited.length; j++) {
                    if (!visited[j] && table[cur][j]) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }

        }
        return count;
    }
}
