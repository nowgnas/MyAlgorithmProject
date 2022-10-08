package algorithm.class0824.탈출;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int R, C, result = Integer.MAX_VALUE;
    static int[] inputs;
    static String[][] map;
    static Queue<int[]> gosm = new LinkedList<>();
    static Queue<int[]> water = new LinkedList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = inputs[0];
        C = inputs[1];
        map = new String[R][C];

        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                String item = line[j];
                map[i][j] = item;
                if ("*".equals(item)) {
                    water.add(new int[]{i, j});
                } else if ("S".equals(item)) {
                    gosm.add(new int[]{i, j, 0});
                }
            }
        }

        // 물에는 bfs를 사용
        bfs();
        System.out.println(result == Integer.MAX_VALUE ? "KAKTUS" : result);

    }

    static void bfs() {

        while (!gosm.isEmpty()) {
            // 물 부터
            int len = water.size();
            for (int i = 0; i < len; i++) {
                int[] curW = water.poll();
                int curY = curW[0];
                int curX = curW[1];

                for (int j = 0; j < 4; j++) {
                    int ny = curY + dy[j];
                    int nx = curX + dx[j];
                    if (ny >= 0 && nx >= 0 && ny < R && nx < C && ".".equals(map[ny][nx])) {
                        map[ny][nx] = "*";
                        water.add(new int[]{ny, nx});
                    }
                }
            }

            len = gosm.size();
            for (int k = 0; k < len; k++) {
                // 큐에서 pop 한 좌표
                int[] cur = gosm.poll();
                int curY = cur[0];
                int curX = cur[1];
                int time = cur[2];

                for (int i = 0; i < 4; i++) {
                    int ny = curY + dy[i];
                    int nx = curX + dx[i];

                    if (ny >= 0 && nx >= 0 && ny < R && nx < C) {
                        if ("D".equals(map[ny][nx])) {
                            result = Math.min(result, time + 1);
                            return;
                        } else if (".".equals(map[ny][nx])) {
                            // 방문 하지 않고 .인 경우만 갈 수 있음
                            map[ny][nx] = "S";
                            gosm.add(new int[]{ny, nx, time + 1});
                        }
                    }
                }
            }
        }
    }
}
