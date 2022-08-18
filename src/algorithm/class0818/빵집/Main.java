package algorithm.class0818.빵집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/3109
 * */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C;
    static String[][] table;
    static boolean[][] visited;
    static int[] inputs;
    static int[] dy = {-1, 0, 1};
    static int[] dx = {1, 1, 1};
    static boolean check, flag;
    static int cnt;

    public static void main(String[] args) throws IOException {
        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = inputs[0];
        C = inputs[1];
        table = new String[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            table[i] = br.readLine().split("");
        } // 입력 끝
        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(table[i]));
        }

        for (int i = 0; i < C; i++) {
            // 1행 다 돌기
            visited[i][0] = true;
            dfs(i, 0);
        }
        System.out.println(cnt);
        for (int i = 0; i < visited.length; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
    }

    private static void dfs(int y, int x) {
        if (x == C - 1) {
            cnt += 1;
            flag = true;
            return;
        }
        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
            if (visited[ny][nx] || table[ny][nx].equals("x")) continue;

            visited[ny][nx] = true;
            dfs(ny, nx);
            if (flag) visited[ny][nx] = true;
            else visited[ny][nx] = false;
        }
    }
}
