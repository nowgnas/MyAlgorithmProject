package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P025_BJ16926_배열돌리기1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int n, m, r;
    static int[][] board;
    static int[][] visit;
    static int ny, nx, dy, dx, y, x;


    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = array[0];
        m = array[1];
        r = array[2];
        board = new int[n][];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int rotate = Math.min(n, m) / 2;


        for (int i = 0; i < r; i++) {
            visit = new int[n][m];
            for (int j = 0; j < rotate; j++) {
                int directionIdx = 0;
                y = x = j;

                int temp = board[y][x];
                int nextTemp;


                // 방향이 4번이상 꺾이면 종료
                while (directionIdx < 4) {
                    dy = direction[directionIdx][0];
                    dx = direction[directionIdx][1];
                    ny = y + dy;
                    nx = x + dx;

                    // 배열 밖을 벗어나거나 이미 방문한 지점이면 방향을 꺾는다
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m || visit[ny][nx] == 1) {
                        directionIdx += 1;
                    } else {
                        // 다음 좌표값을 임시로 저장을 해둔다.
                        nextTemp = board[ny][nx];
                        // 이전 임시값을 현재 좌표에 저장한다.
                        board[ny][nx] = temp;
                        //다음 임시좌표값을 임시값으로 바꾸어서 저장한다.
                        temp = nextTemp;
                        visit[ny][nx] = 1;
                        y = ny;
                        x = nx;

                    }

                }


            }

        }

        // 배열을 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }
}
