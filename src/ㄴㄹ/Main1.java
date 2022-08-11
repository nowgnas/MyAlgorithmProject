package ㄴㄹ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    public static int N, M, K;
    public static int[][] map;
    // 하 좌 상 우
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int answer = Integer.MAX_VALUE;
    public static int[] order;
    public static boolean[] used;

    public static int[][] cal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // 배열을 받아와 저장한다.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 연산에 대한 정보를 저장하는 배열
        cal = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cal[i][0] = Integer.parseInt(st.nextToken());
            cal[i][1] = Integer.parseInt(st.nextToken());
            cal[i][2] = Integer.parseInt(st.nextToken());
        }

        // 연산의 순서를 저장하는 배열
        order = new int[K];
        // 순열을 만들 때, i번째 연산이 포함되었는지 안되었는지를 판별하는 배열
        used = new boolean[K];
        Perm(0);
        System.out.println(answer);
    }

    public static void Rotation() {
        // map배열을 사용하여 연산하게 되면 다음 연산에 영향을 주므로 복사하여 사용한다.
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
        // x,y좌표가 1부터 시작하므로 1을 빼주어 배열의 idx와 같게 해준다.
        for (int t : order) {
            int x = cal[t][0] - 1;
            int y = cal[t][1] - 1;
            int s = cal[t][2];
            for (int i = 1; i <= s; i++) {
                int dir = 0;
                int a = x - i;
                int b = y - i;
                int temp = copy[a][b];
                while (dir < 4) {
                    int next_x = a + dx[dir];
                    int next_y = b + dy[dir];

                    if (next_x >= x - i && next_y >= y - i && next_x <= x + i && next_y <= y + i) {
                        copy[a][b] = copy[next_x][next_y];
                        a = next_x;
                        b = next_y;
                    } else {
                        dir++;
                    }
                }
                copy[x - i][y - i + 1] = temp;
            }
        }
        // 가장 합이 작은 행을 구하는 연산
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += copy[i][j];
            }
            answer = Math.min(answer, sum);
        }
    }

    // 받아온 계산들의 순열을 만들어주는 메서드
    public static void Perm(int depth) {
        // 계산들의 순서를 다 지정하면 그 계산들을 가지고 연산을 진행한다.
        if (depth == K) {
            Rotation();
            return;
        }
        for (int i = 0; i < K; i++) {
            if (!used[i]) {
                used[i] = true;
                order[depth] = i;
                Perm(depth + 1);
                used[i] = false;
            }
        }
    }
}