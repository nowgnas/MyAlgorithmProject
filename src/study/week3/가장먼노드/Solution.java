package study.week3.가장먼노드;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    static int cnt;

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        // n * n 테이블에 무향 그래프를 넣는다
        boolean[][] table = new boolean[n + 1][n + 1];
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
        Queue<Integer> queue = new ArrayDeque<>(); // bfs를 위한 큐

        visited[1] = true; // 방문 처리
        queue.offer(1); // 큐에 시작 1 추가
        int count = 0;

        while (!queue.isEmpty()) { // 큐가 빌 때 까지
            count = queue.size(); // 큐의 현재 크기

            System.out.println(queue);

            for (int i = 0; i < count; i++) {
                int cur = queue.poll(); // 큐 pop 현재 값 보기

                System.out.println(cur); // 방금 꺼낸 값 확인하기

                for (int j = 0; j < visited.length; j++) {
                    if (!visited[j] && table[cur][j]) { // visited 배열에서 방문하지 않은 true이면
                        visited[j] = true; // 방문 처리
                        queue.add(j); // 큐에 추가
                    }
                }
            }
        }
        return count;
    }
}
