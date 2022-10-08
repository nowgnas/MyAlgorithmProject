package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P044_BJ1987_알파벳 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R;
    static int C;
    static int[] inputs;
    static int[][] table;
    static boolean[] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static boolean check;
    static int answer;

    public static void main(String[] args) throws IOException {
        inputs = new int[2];
        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = inputs[0];
        C = inputs[1];
        table = new int[R][C];
        visited = new boolean[26]; // 방문 테이블 26개 알파벳 만큼

        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < line.length; j++) {
                char alpha = line[j].charAt(0);
                table[i][j] = alpha - 'A';
            }
        }
        answer = Integer.MIN_VALUE;

        visited[table[0][0]] = true;
        dfs(0, 0, 1);
    }

    private static boolean dfs(int y, int x, int cnt) {
        answer = Math.max(answer, cnt);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue; // 테이블 밖
            if (visited[table[ny][nx]]) continue;
            visited[table[ny][nx]] = true;
            check = dfs(ny, nx, cnt + 1);
            visited[table[ny][nx]] = false;
        }
        return check;
    }

    private static void backTracking() {

    }
}
