package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob2 {
    static class Core {
        int y, x;

        public Core(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static boolean[] visited;
    static int[][] map, mapCopy;
    static List<Core> list;
    static int[] idx;
    static int N, result;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            // 테스트 케이스 시작
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            list = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int k = 0; k < N; k++) {
                    if (line[k] == 1 && (j == 0 || k == 0 || j == N - 1 || k == N - 1)) {
                        map[j][k] = 2;
                    } else {
                        map[j][k] = line[k];
                        if (line[k] == 1)
                            list.add(new Core(j, k));
                    }
                }
            }
            visited = new boolean[list.size()];
            idx = new int[list.size()];
            int[] arr = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                arr[j] = j;
            }
            result = Integer.MAX_VALUE;
            perm(0, list.size(), arr);
            System.out.println("#" + i + " " + result);
        }
    }

    static void perm(int cnt, int r, int[] arr) {
        if (cnt == r) {
            // 순열이 만들어 짐
            mapCopy = new int[N][N];
            flag = false;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    mapCopy[j][k] = map[j][k];
                }
            } // 지도 복사
            int lineCnt = 0;
            for (int item :
                    idx) {
                Core matrix = list.get(item);
                lineCnt += checkLength(matrix.y, matrix.x, mapCopy);
                if (!flag) return;
            }
            result = Math.min(result, lineCnt);
            return;
        }

        for (int i = 0; i < r; i++) {
            if (visited[i]) continue;
            idx[cnt] = arr[i];
            visited[i] = true;
            perm(cnt + 1, r, arr);
            visited[i] = false;
        }
    }

    static int checkLength(int y, int x, int[][] mapCopy) {

        // 상 하 좌 우 길이 계산, 젤 짧은거로
        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[] directVal = new int[4];
        for (int i = 0; i < 4; i++) {
            int ny = y;
            int nx = x;
            while (true) {
                ny += direction[i][0];
                nx += direction[i][1];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N) break;
                if (mapCopy[ny][nx] != 0) {
                    directVal[i] = Integer.MAX_VALUE;
                    break;
                }
                if (mapCopy[ny][nx] == 0) {
                    directVal[i]++;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            if (directVal[i] == 0) {
                directVal[i] = Integer.MAX_VALUE;
            }
        }
        int minVal = Integer.MAX_VALUE;
        int finalDirection = -1;
        for (int i = 0; i < 4; i++) {
            if (minVal > directVal[i] && directVal[i] != Integer.MAX_VALUE) {
                finalDirection = i;
                minVal = directVal[i];
            }
        }
        if (finalDirection == -1) {
            flag = false;
            return 0;
        } else {
            flag = true;
            while (true) {
                y += direction[finalDirection][0];
                x += direction[finalDirection][1];
                if (y < 0 || x < 0 || y >= N || x >= N || mapCopy[y][x] != 0) break;
                mapCopy[y][x] = 1;
            }
            return minVal;
        }

    }
}

/*

1
7
0 0 1 0 0 0 0
0 0 1 0 0 0 0
0 0 0 0 0 1 0
0 0 0 0 0 0 0
1 1 0 1 0 0 0
0 1 0 0 0 0 0
0 0 0 0 0 0 0

* */