package kang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P005_SWEA1210_Ladder1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int N = 100; // 100*100 2차원 배열을 주기위해

        for (int tc = 1; tc <= 10; tc++) { //10 개의 test case 돌린다

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                int j = 0;
                while (st.hasMoreTokens()) {
                    int nums = Integer.parseInt(st.nextToken());
                    map[i][j] = nums;
                    j++;
                }
/*                for (int j = 0; j < N; j++) {
                    int nums = Integer.parseInt(st.nextToken());
                    map[i][j] = nums;
                }*/
            } // 입력 완료 !

            int x = 0;
            int y = 0;
            //도착 지점의 좌표를 저장해두기 > 거꾸로 올라가며 출발 index 찾을 예정 !
            for (int j = 0; j < N; j++) {
                if (map[99][j] == 2) { // 2 값을 가진 index 가 바로 도착지점
                    x = 99;
                    y = j;
                }
            }

            // 좌우 방향검사를 위해 ..
            int[] dx = {0, 0, -1};
            int[] dy = {-1, 1, 0};

            // x가 0번째 행일때 탈출
            while (x != 0) {// 전체를 탐색 하자
                for (int d = 0; d < 3; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (ny < 0 || nx >= N - 1 || ny >= N - 1) continue; // 범위 벗어나는 경우
                    if (map[nx][ny] == 2) continue; // 방문한 좌표인 경우

                    if (map[nx][ny] == 1) { // 방문하지 않은 갈 수 있는 좌표
                        x = nx; // 다음 x좌표
                        y = ny; // 다음 y좌표
                        map[x][y] = 2; // 넘어갈 좌표를 방문처리
                        break;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, y); // 0 행 중 .. 정답 인덱스 ... 뭐 ..
        }
    } //main end
}
