package algorithm.class1004.벽돌깨기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class dfs {
    static int T, n, w, h, min;
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];

            for (int j = 0; j < h; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < w; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            go(map, 0);
            System.out.println("#" + i + " " + min);
            // 테스트 케이스 끝
        }

    }

    // 구슬 던지기 게임
    static boolean go(int[][] map, int cnt) {

        int result = getRemain(map);
        if (result == 0) {
            min = result;
            return true;
        }
        if (cnt == n) {
            if (min > result) min = result;
            return false;
        }

        int[][] newMap = new int[h][w];
        // 구슬 던지기 (중복 순열)
        for (int c = 0; c < w; c++) {
            // 구슬에 맞는 시작 벽돌 찾기
            int r = 0;
            while (r < h && map[r][c] == 0) ++r;
            if (r == h) { // 맞는 시작 벽돌이 없는 상태
                continue;  //////////////////////////
            } else { // 맞는 시작 벽돌이 있는 상태
                copy(map, newMap);
                // 제거될 벽돌 연쇄 처리
                boom(newMap, r, c, newMap[r][c]);
                // 벽돌 중력 처리
                down(newMap);
                // 다음 구슬 던지기
                if (go(newMap, cnt + 1)) return true;
            }
        }
        return false;
    }

    private static int getRemain(int[][] map) {
        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] > 0) result++;
            }
        }
        return result;
    }

    static Stack<Integer> stack = new Stack<>();

    private static void down(int[][] map) {
        for (int c = 0; c < w; c++) {
            for (int r = 0; r < h; r++) {
                if (map[r][c] > 0) {
                    stack.push(map[r][c]);
                    map[r][c] = 0;
                }
            } // 남은 벽돌은 스택에 들어있고 모든 칸은 빈칸이다
            int nr = h - 1;
            while (!stack.isEmpty()) {
                map[nr--][c] = stack.pop();
            }


        }
    }

    private static void boom(int[][] map, int r, int c, int cnt) { // dfs
        map[r][c] = 0; // 방문 처리 ==> 제거 처리\
        if (cnt == 1) return;

        for (int i = 0; i < 4; i++) {
            int nr = r;
            int nc = c;
            for (int j = 0; j < cnt; j++) {
                nr += dy[i];
                nc += dx[i];
                if (nr >= 0 && nc >= 0 && nr < h && nc < w && map[nr][nc] > 0) {
                    boom(map, nr, nc, map[nr][nc]); // 벽돌이면 재귀
                }
            }

        }
    }

    static void copy(int[][] map, int[][] newMap) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                newMap[i][j] = map[i][j];
            }
        }
    }

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

}

