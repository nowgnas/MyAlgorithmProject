package ㄴㄹ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, K;

    static int[][] arr;
    static boolean[] visited;
    static int[] com;
    static int[][] in;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        visited = new boolean[K];
        com = new int[K];
        in = new int[K][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            in[k][0] = Integer.parseInt(st.nextToken());
            in[k][1] = Integer.parseInt(st.nextToken());
            in[k][2] = Integer.parseInt(st.nextToken());
        }

        perm(0);
        System.out.println(min);
    }

    public static void rotation() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = arr[i].clone();
        }

        for (int k : com) {
            int s = in[k][2];
            int x = in[k][0] - 1;
            int y = in[k][1] - 1;

            for (int i = 1; i <= s; i++) {
                int a = x - i;
                int b = y - i;
                int tmp = copy[a][b];
                int dir = 0;
                while (dir < 4) {
                    int nx = a + dx[dir];
                    int ny = b + dy[dir];

                    if (nx >= x - i && ny >= y - i && nx <= x + i && ny <= y + i) {
                        copy[a][b] = copy[nx][ny];
                        a = nx;
                        b = ny;
                    } else {
                        dir++;
                    }
                }
                copy[x - i][y - i + 1] = tmp;
            }
        }
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += copy[i][j];
            }
            min = Math.min(min, sum);
        }
    }

    public static void perm(int cnt) {
        if (cnt == K) {
            rotation();
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                com[cnt] = i;
                perm(cnt + 1);
                visited[i] = false;
            }

        }
    }

}

