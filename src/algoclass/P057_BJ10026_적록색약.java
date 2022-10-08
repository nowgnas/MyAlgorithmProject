package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P057_BJ10026_적록색약 {
    static int N, count, answer, answer2;
    static String[][] map, map2;
    static boolean[][] visited, visited2;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        visited2 = new boolean[N][N];
        count = 0;
        map = new String[N][N];
        map2 = new String[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = line[j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ("R".equals(map[i][j])) {
                    map2[i][j] = "G";
                } else {
                    map2[i][j] = map[i][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map, visited);
                    answer++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited2[i][j]) {
                    dfs(i, j, map2, visited2);
                    answer2++;
                }
            }
        }

        System.out.println(answer + " " + answer2);


    }

    static boolean dfs(int y, int x, String[][] map, boolean[][] visited) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;

            if (!visited[ny][nx] && map[y][x].equals(map[ny][nx])) {
                // 다음 볼 좌표를 방문하지 않았고 현재 좌표랑 값이 같을 때
                check = dfs(ny, nx, map, visited); // 재귀
            }
        }
        return check;
    }
}
