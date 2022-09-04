package study.week5.경주로건설;

import java.util.*;

public class Solution2 {

    static int[][] map;
    static int r, c, answer;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static class Node {
        int y, x, direction, cost;

        public Node(int y, int x, int direction, int cost) {
            this.y = y;
            this.x = x;
            this.direction = direction;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};

//        int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}; // 900
//        int[][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
//        int[][] board = {
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 0, 1, 1, 1, 1, 1, 0},
//                {1, 0, 0, 1, 0, 0, 0, 0},
//                {1, 1, 0, 0, 0, 1, 1, 1},
//                {1, 1, 1, 1, 0, 0, 0, 0},
//                {1, 1, 1, 1, 1, 1, 1, 0},
//                {1, 1, 1, 1, 1, 1, 1, 0},
//                {1, 1, 1, 1, 1, 1, 1, 0}
//        };
        // 4500

        /*
         * 0은 빈칸
         * 1은 벽
         * 출발점 0, 0
         * 도착점 N-1, N-1
         * 끊기지 않도록 경주로 건설
         * 상 하 좌 우 인접 두 빈칸을 연결하여 건설
         * 벽에는 설치 못함
         * 연결한 경주로를 직선 도로라고 함
         * 직각으로 만나는 지점을 코너라고 함
         * 직선 도로는 100원 코너는 500원
         * 도로 건설에 최소 비용을 구하라
         * 이전 좌표를 가지고 있어야 하나??
         */
        r = board.length;
        c = board[0].length;

        map = new int[r][c];
        answer = Integer.MAX_VALUE;

        bfs(board);
        System.out.println(answer);


    }

    static void bfs(int[][] board) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0, -1, 0));
        map[0][0] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int y = cur.y;
            int x = cur.x;
            int cost = cur.cost;
            int dir = cur.direction;

            if (y == r - 1 && x == c - 1) {
                answer = Math.min(answer, cost);
                continue;
            }


            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= r || nx >= c || board[ny][nx] == 1) continue;

                int newCost = cost;

                if (dir == i || dir == -1) {
                    newCost += 100;
                } else {
                    newCost += 600;
                }
                if (map[ny][nx] == 0) {
                    map[ny][nx] = newCost;
                    queue.add(new Node(ny, nx, i, newCost));
                } else if (map[ny][nx] >= newCost) {
                    map[ny][nx] = newCost;
                    queue.add(new Node(ny, nx, i, newCost));
                }
            }
        }
    }
}

/* 3800 */