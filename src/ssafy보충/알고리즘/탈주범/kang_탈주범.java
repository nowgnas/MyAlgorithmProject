package ssafy보충.알고리즘.탈주범;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class kang_탈주범 {
    static class Node {
        int r, c, cnt;

        public Node(int r, int c, int cnt) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

    }

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
    static int[] dy = {-1, 1, 0, 0};
    static int[][] tunnel = new int[][]{{}, {0, 1, 2, 3}, {0, 1}, {2, 3}, {0, 3}, {1, 3}, {1, 2}, {0, 2}}; // 터널별 이동 가능한 방향
    static int N, M, R, C, L;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 개수
        for (int tc = 1; tc <= T; tc++) {
            String s[] = bf.readLine().split(" ");
            N = Integer.parseInt(s[0]); // 세로
            M = Integer.parseInt(s[1]); // 가로
            R = Integer.parseInt(s[2]); // 멘홀 위치한 세로
            C = Integer.parseInt(s[3]); // 멘홀 위치한 가로
            L = Integer.parseInt(s[4]); // 탈출 후 소요된 시간

            map = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                String s2[] = bf.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(s2[j]);
                }
            } // 입력 완료

            System.out.println("#" + tc + " " + bfs());

        } // test case end
    } // main end

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(C, R, 1)); // 멘홀 뚜껑 시작점 , 주어진 시간 L만큼 탐색
        visited[C][R] = true;

        while (!q.isEmpty()) {
            // 탐색 시간을 다 쓴 경우
            if (L < 0) break;

            int size = q.size(); //..
        }
        return 0;
    }

}


