package algorithm.class0819.캐슬디펜스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, D;
    static int[][] map;
    static int[] inputs;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        M = inputs[1];
        D = inputs[2];

        map = new int[N + 1][M];
        visited = new boolean[M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < M; i++) {
            map[N][i] = -2;
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        comb(3, 0);
    }

    private static void attack() {

    }

    private static void swap(int y, int x, int y2, int x2, int[][] arr) {
        int temp = arr[y][x];
        arr[y][x] = 0;
        arr[y2][x2] = temp;
    }

    private static void comb(int pick, int cnt) { // 조합 성공

        if (pick == 0) { // 하나의 조합 에서 턴이 끝날 때 까지 돌아야 한다.
            int[][] copy = new int[N + 1][M];

            for (int i = 0; i < N; i++) {  // map을 복사
                for (int j = 0; j < M; j++) {
                    copy[i][j] = map[i][j];
                }
            }
            for (int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(copy));
            }

            // 모든 턴이 끝나야 함
            // 적은 아래로 한칸씩 내려오게 됨


            return;
        }
        if (cnt == M) return;
        visited[cnt] = true;
        comb(pick - 1, cnt + 1);
        visited[cnt] = false;
        comb(pick, cnt + 1);
    }
}
