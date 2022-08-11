package ㄴㄹ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class aerim {
    private static int n, m, r;
    private static int[][] data;
    private static int[][] cal;

    private static int min = Integer.MAX_VALUE;
    private static int[] output;
    private static boolean[] visited;


    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        // 배열의 크기 n,m  연산수 r
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());


        // 배열
        data = new int[n][m];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(in.readLine());
            for (int x = 0; x < m; x++) {
                data[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        // 연산 저장
        cal = new int[r][3];
        for (int y = 0; y < r; y++) {
            st = new StringTokenizer(in.readLine());
            cal[y][0] = Integer.parseInt(st.nextToken());
            cal[y][1] = Integer.parseInt(st.nextToken());
            cal[y][2] = Integer.parseInt(st.nextToken());
        }

        // 순열 및 rotation 함수를 위한 준비
        visited = new boolean[r];
        output = new int[r];
        // 순서 찾기
        Order(0);


        System.out.println(min);


    }

    // 돌리기~
    public static void Rotation() {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            // clone 복사
            map[i] = data[i].clone();
        }
        for (int i : output) {
            int startY = cal[i][0] - cal[i][2] - 1;
            int startX = cal[i][1] - cal[i][2] - 1;

            int endY = cal[i][0] + cal[i][2] - 1;
            int endX = cal[i][1] + cal[i][2] - 1;

            // 돌릴 직사각형 크기
            int width = endX - startX + 1;
            int height = endY - startY + 1;

            int rectCount = Math.min(width, height) / 2;

            for (int j = 0; j < rectCount; j++) {
                startY += j;
                startX += j;
                endY -= j;
                endX -= j;
                // 빈공간 생성
                int temp = map[startY][startX];

                // 좌변 : 아래에서 위로 이동
                for (int x = startY; x < endY; x++) {
                    map[x][startX] = map[x + 1][startX];
                }

                // 아랫변 : 오른쪽에서 왼쪽에서 이동
                for (int x = startX; x < endX; x++) {
                    map[endY][x] = map[endY][x + 1];
                }

                // 우변 : 위에서 아래로 이동
                for (int x = endY; x > startY; x--) {
                    map[x][endX] = map[x - 1][endX];
                }

                // 윗변 : 왼쪽에서 오른쪽이동
                for (int x = endX; x > startX; x--) {
                    map[startY][x] = map[startY][x - 1];
                }

                map[startY][startX + 1] = temp;

            }


            for (int y = 0; y < n; y++) {
                int sum = 0;
                for (int x = 0; x < m; x++) {
                    sum += map[y][x];
                }
                if (sum < min) {
                    min = sum;
                }
            }

        }

    }


    // 연산 순서 정하기.
    public static void Order(int count) {
        if (count == r) {
            Rotation();
            return;
        }

        for (int t = 0; t < r; t++) {
            if (!visited[t]) {
                visited[t] = true;
                output[count] = t;
                Order(count + 1);
                visited[t] = false;
            }
        }

    }
}