package study.week10.욕심쟁이판다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, result = Integer.MIN_VALUE;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map, resMap;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        resMap = new int[n][n]; // dp 값을 저장할 배열

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }// 입력 완료

        for (int i = 0; i < n; i++) { // 모든 좌표를 확인 하면서
            for (int j = 0; j < n; j++) {
                int unitRes = dfs(i, j); // dfs로 최대값 갱신
                result = Math.max(result, unitRes);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(resMap[i]));
        }
        System.out.println(result);
    }

    static int dfs(int startY, int startX) {

        if (resMap[startY][startX] != 0) return resMap[startY][startX]; // 이미 갱신 되었으면 해당 값을 반환

        resMap[startY][startX] = 1; // 시작 값을 1초 초기화

        for (int i = 0; i < 4; i++) { // 4 방향을 확인 하면서
            int ny = startY + dy[i];
            int nx = startX + dx[i];
            if (checkRange(ny, nx) && map[startY][startX] < map[ny][nx]) { // 범위 안, map에서 현재 좌표보다 다음 보는 좌표가 크면 갈 수 있으므로 dfs 재귀
                resMap[startY][startX] = Math.max(resMap[startY][startX], dfs(ny, nx) + 1);
            }
        }
        return resMap[startY][startX];
    }


    static boolean checkRange(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < n && nx < n;
    }
}
