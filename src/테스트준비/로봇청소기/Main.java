package 테스트준비.로봇청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = nm[0];
        int M = nm[1];

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = line[0];
        int c = line[1];
        int d = line[2];
        // 0: 북쪽 1: 동쪽 2: 남쪽 3: 서쪽

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        dfs(r, c, d, visited);
    }

    static void dfs(int y, int x, int d, boolean[][] visited) {
        int[] dy = {0};
        int[] dx = {-1};

        // 현재 위치 청소
        visited[y][x] = true; // 청소 완료
        switch (d) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }

    }
}
