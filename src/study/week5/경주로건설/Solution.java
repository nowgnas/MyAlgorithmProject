package study.week5.경주로건설;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    static int[][] map;
    static boolean[][] visited;
    static int r, c;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static class Node {
        int py, px, y, x, cost;

        public Node(int py, int px, int y, int x, int cost) {
            this.py = py;
            this.px = px;
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};

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
        visited = new boolean[r][c];

        bfs();
        System.out.println(map[r - 1][c - 1]);


    }

    static void bfs() {
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });
        queue.offer(new Node(0, 0, 0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            for (int j = 0; j < queue.size(); j++) {
                Node cur = queue.poll();
                int py = cur.py;
                int px = cur.px;
                int y = cur.y;
                int x = cur.x;
                int cost = cur.cost;

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
                    boolean direction = py - y != 0 || px - x != 0; // 방향이 바뀌는지

                    if (!visited[ny][nx] && map[ny][nx] != 1) {
                        visited[ny][nx] = true;
                        if (direction) {
                            // 방향이 안바뀐 경우
                            map[ny][nx] = map[y][x] + 100;
                            queue.offer(new Node(y, x, ny, nx, 100));
                        } else {
                            // 방향이 바뀐 경우
                            map[ny][nx] = map[y][x] + 500;
                            queue.offer(new Node(y, x, ny, nx, 500));
                        }
                    }
                }

            }

        }

    }
}

/* 3800 */