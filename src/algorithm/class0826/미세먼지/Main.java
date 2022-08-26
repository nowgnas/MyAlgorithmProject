package algorithm.class0826.미세먼지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] map, copyMap;
    static List<int[]> queue = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];


        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    queue.add(new int[]{i, j});
                }
            }
        }// 입력 끝
        // ------------------------- 큐가 필요가 없을 수도??! -------------------------
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        for (int i = 0; i < T; i++) {
            // 시간 T 만큼
            copyMap = new int[R + 1][C + 1]; // 확산을 저장할 배열
            for (int j = 1; j <= R; j++) {
                for (int k = 1; k <= C; k++) {
                    // map을 돌면서
                    if (map[j][k] == -1) {
                        copyMap[j][k] = -1;
                        continue;
                    }
                    copyMap[j][k] += map[j][k];
                    int spreadVal = spread(map[j][k]);
                    for (int l = 0; l < 4; l++) {
                        int ny = j + dy[l]; // 다음 볼 좌표 Y
                        int nx = k + dx[l]; // 다음 볼 좌표 X

                        if (ny <= 0 || nx <= 0 || ny > R || nx > C || map[ny][nx] == -1) continue; // 지도 밖이면 다음 좌표
                        copyMap[ny][nx] += spreadVal;
                        copyMap[j][k] -= spreadVal;
                    }
                }
            }

            // 공기 청정기 돌리기
            // 위 공기 청정기
            int[] up = queue.get(0);
            int upY = up[0];
            int upX = up[1];

            for (int j = upY - 1; j > 1; j--) {
                copyMap[j][1] = copyMap[j - 1][1];
            }
            for (int j = 1; j < C; j++) {
                copyMap[1][j] = copyMap[1][j + 1];
            }
            for (int j = 1; j < upY; j++) {
                copyMap[j][C] = copyMap[j + 1][C];
            }
            for (int j = C; j > upX + 1; j--) {
                copyMap[upY][j] = copyMap[upY][j - 1];
            }
            copyMap[upY][2] = 0;


            // 아래 공기 청정기
            int[] down = queue.get(1);
            int downY = down[0];
            int downX = down[1];

            for (int j = downY + 1; j < R; j++) {
                copyMap[j][1] = copyMap[j + 1][1];
            }
            for (int j = 1; j < C; j++) {
                copyMap[R][j] = copyMap[R][j + 1];
            }
            for (int j = R; j > downY; j--) {
                copyMap[j][C] = copyMap[j - 1][C];
            }
            for (int j = C; j > downX + 1; j--) {
                copyMap[downY][j] = copyMap[downY][j - 1];
            }
            copyMap[downY][2] = 0;

            for (int j = 1; j <= R; j++) { // 배열 복사
                for (int k = 1; k <= C; k++) {
                    map[j][k] = copyMap[j][k];
                }
            }

        }
        int sum = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (copyMap[i][j] == -1) continue;
                sum += copyMap[i][j];
            }
        }
        System.out.println(sum);

    }


    static int spread(int pm) {
        return pm / 5;
    }
}
