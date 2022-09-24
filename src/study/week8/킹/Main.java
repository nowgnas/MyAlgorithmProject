package study.week8.킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] king, rock;
    static String kingMatrix, rockMatrix;
    static BufferedReader br;
    static StringTokenizer st;
    static int ny, nx, ry, rx;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        kingMatrix = st.nextToken();
        rockMatrix = st.nextToken();

        char[] kingArr = kingMatrix.toCharArray();
        char[] rockArr = rockMatrix.toCharArray();

        king = new int[]{(int) kingArr[0] - 'A' + 1, Integer.parseInt(String.valueOf(kingArr[1]))};
        rock = new int[]{(int) rockArr[0] - 'A' + 1, Integer.parseInt(String.valueOf(rockArr[1]))};

        ny = king[0];
        nx = king[1];
        ry = rock[0];
        rx = rock[1];
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            switch (command) {
                case "R" :
                    check(1, 0);
                    break;
                case "L" :
                    check(-1, 0);
                    break;
                case "B" :
                    check(0, -1);
                    break;
                case "T" :
                    check(0, 1);
                    break;
                case "RT" :
                    check(1, 1);
                    break;
                case "LT" :
                    check(-1, 1);
                    break;
                case "RB" :
                    check(1, -1);
                    break;
                case "LB" :
                    check(-1, -1);
                    break;
            }

        }
        System.out.println((char) (ny + 'A' - 1) + "" + nx);
        System.out.println((char) (ry + 'A' - 1) + "" + rx);

    }

    static void check(int diffY, int diffX) {
        int newY = ny + diffY;
        int newX = nx + diffX;
        if (newY < 1 || newX < 1 || newY >= 9 || newX >= 9) {
            return;
        }
        if (newY == ry && newX == rx) {
            int newrY = ry + diffY;
            int newrX = rx + diffX;
            if (newrY < 1 || newrX < 1 || newrY >= 9 || newrX >= 9) {
                return;
            }
            ry += diffY;
            rx += diffX;
        }
        ny += diffY;
        nx += diffX;
    }
}
