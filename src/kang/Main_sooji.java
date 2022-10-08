package kang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main_sooji {
    static class node {
        int x, y;

        public node(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, max, zero, copyzero;
    static int[][] map, copymap;
    static ArrayList<node> list;
    static int[] idx;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s[] = bf.readLine().split(" ");
        N = Integer.parseInt(s[0]); // 세로
        M = Integer.parseInt(s[1]); // 가로

        map = new int[N][M];
        copymap = new int[N][M];
        list = new ArrayList<>();
        idx = new int[3];

        for (int i = 0; i < N; i++) {
            String s2[] = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s2[j]);

                if (map[i][j] == 0) { // 0 인 좌표를 저장 !
                    list.add(new node(i, j));
                    zero++;
                }
            }
        } // 입력 완료

        max = Integer.MIN_VALUE; // 최대 안전지역 개수 !
        comb(0, 0);
        System.out.println(max);
    }

    private static void comb(int cnt, int start) { // 0 인 좌표로 조합을 만들자 ! 벽을 세우기 위해
        if (cnt == 3) { // 벽은 3개를 세운 경우
            copyzero = zero; // 얘도 .. 복사해야된다
            copy(); // map 복사

            // 벽을 세우기 ..
            for (int i = 0; i < 3; i++) {
                node tmp = list.get(idx[i]);
                copymap[tmp.x][tmp.y] = 1;
                copyzero -= 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copymap[i][j] == 2) {
                        bfs(i, j);
                    }
                }
            }

            max = Math.max(max, copyzero);
            return;
        }

        for (int i = start; i < list.size(); i++) {
            idx[cnt] = i; // 좌표의 인덱스 ..

            comb(cnt + 1, i + 1);
        }
    }

    private static void bfs(int i, int j) { // 바이러스 퍼뜨리기
        Queue<node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        q.offer(new node(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            node n = q.poll();
            int x = n.x;
            int y = n.y;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 범위내 존재하고 ..
                    if (!visited[nx][ny] && copymap[nx][ny] == 0) {
                        q.add(new node(nx, ny));
                        visited[nx][ny] = true;

                        copymap[nx][ny] = 2; // 바이러스 퍼뜨리기
                        copyzero--;
                    }
                }
            }
        }
    }

    private static void copy() { // 조합의 경우 다 복사본 사용 ~
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copymap[i][j] = map[i][j];
            }
        }
    }

}