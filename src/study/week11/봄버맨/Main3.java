package study.week11.봄버맨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    static int r, c, n;
    static char[][] map;
    static int[][] numMap;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        numMap = new int[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'O') numMap[i][j] = 3;
            }
        }
        int time = 1;
        while (time++ < n) {
            if (time % 2 == 0) {
                fill();
            }
            bomb();

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (numMap[i][j] <= 0) System.out.print(".");
                    else System.out.print("O");
                }
                System.out.println();
            }
        }


    }

    private static void bomb() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                numMap[i][j]--;
                if (numMap[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = i + dx[k];
                        if (checkRange(ny, nx)) {
                            numMap[ny][nx] = 0;
                        }
                    }
                }
            }
        }
    }

    static boolean checkRange(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < r && nx < c;
    }

    static void fill() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (numMap[i][j] <= 0) {
                    numMap[i][j] = 3 + n;
                }
            }
        }
    }
}
