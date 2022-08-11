package algorithm.class0810.배열돌리기;

/*

 * https://www.acmicpc.net/problem/16926
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
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


                while (true) {
                    if (directionIdx >= 4) {
                        break;
                    }
                    dy = direction[directionIdx][0];
                    dx = direction[directionIdx][1];
                    ny = y + dy;
                    nx = x + dx;

                    if (ny < 0 || ny >= n || nx < 0 || nx >= m || visit[ny][nx] == 1) {
                        directionIdx += 1;
                    } else {
                        nextTemp = board[ny][nx];
                        board[ny][nx] = temp;
                        temp = nextTemp;
                        visit[ny][nx] = 1;
                        y = ny;
                        x = nx;

                    }

                }


            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }
}
