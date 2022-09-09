package study.week5.경주로건설;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {

    static class Node {
        int x, y, dir, cost;

        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][][] visited;
    static int N;
    static int[][] board = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 0}
    };

    public static void main(String[] args) {

        N = board.length;
        visited = new boolean[N][N][4];
        int result = bfs(board);
        System.out.println(result);

    }

    static int bfs(int[][] board) {
        Queue<Node> q = new LinkedList<>();
        visited[0][0][0] = visited[0][0][1] = visited[0][0][2] = visited[0][0][3];
        q.add(new Node(0, 0, -1, 0));

        int minCost = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N - 1 && cur.y == N - 1) {
                minCost = Math.min(minCost, cur.cost);
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny] != 1) {
                    int nextCost = 0;
                    if (cur.dir == i || cur.dir == -1) {
                        nextCost = cur.cost + 100;
                    } else {
                        nextCost = cur.cost + 600;
                    }

                    if (!visited[nx][ny][i] || board[nx][ny] >= nextCost) {
                        q.add(new Node(nx, ny, i, nextCost));
                        visited[nx][ny][i] = true;
                        board[nx][ny] = nextCost;
                    }
                }
            }
        }
        return minCost;
    }
}
