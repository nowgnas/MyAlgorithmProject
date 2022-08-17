package algorithm.class0817.감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // 감시

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, black, answer;
    private static int[][] table, tempTable;
    private static List<int[]> cctv = new ArrayList<>();

    private static int[][] cctv2;
    private static int[] cctvCase;
    private static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int[] comb;

    public static void main(String[] args) throws IOException {
        input();
        combination(0);
        System.out.println(answer);
    }

    private static void combination(int idx) {

        if (idx == cctv.size()) {
            tempTable = new int[n][m];
            for (int i = 0; i < cctv.size(); i++) {
                int[] cctvData = cctv.get(i);
                switch (cctvData[2]) {
                    case 1:
                        cctv_1(cctvData[0], cctvData[1], comb[i]);
                        break;
                    case 2:
                        cctv_2(cctvData[0], cctvData[1], comb[i]);
                        break;
                    case 3:
                        cctv_3(cctvData[0], cctvData[1], comb[i]);
                        break;
                    case 4:
                        cctv_4(cctvData[0], cctvData[1], comb[i]);
                        break;
                    case 5:
                        cctv_5(cctvData[0], cctvData[1], comb[i]);
                        break;
                }
            }
            int count = black;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (tempTable[i][j] == 1 && table[i][j] == 0) {
                        count -= 1;
                    }
                }
            }
            answer = Math.min(answer, count);
            return;


        }
        for (int i = 0; i < cctvCase[idx]; i++) {
            comb[idx] = i;
            combination(idx + 1);
        }

    }

    private static void input() throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        table = new int[n][n];
        for (int i = 0; i < n; i++) {
            table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        black = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (table[i][j] <= 5 && table[i][j] >= 1) {
                    cctv.add(new int[]{i, j, table[i][j]});
                }
                if (table[i][j] == 0) {
                    black += 1;
                }
            }
        }
        answer = black;
        cctvCase = new int[cctv.size()];
        comb = new int[cctv.size()];
        for (int i = 0; i < cctv.size(); i++) {
            int[] ints = cctv.get(i);
            if (ints[2] == 2) {
                cctvCase[i] = 2;
            } else if (ints[2] == 5) {
                cctvCase[i] = 1;
            } else {
                cctvCase[i] = 4;
            }
        }

    }

    private static void search(int y, int x, int idx) {
        int ny = y + direction[idx][0];
        int nx = x + direction[idx][1];
        while (0 <= ny && ny < n && 0 <= nx && nx < m && table[ny][nx] != 6) {
            tempTable[ny][nx] = 1;
            ny = ny + direction[idx][0];
            nx = nx + direction[idx][1];
        }
    }

    private static void cctv_1(int y, int x, int idx) {
        search(y, x, idx);
    }

    private static void cctv_2(int y, int x, int idx) {
        if (idx == 0) {
            search(y, x, 0);
            search(y, x, 2);
        } else {
            search(y, x, 1);
            search(y, x, 3);
        }

    }


    private static void cctv_3(int y, int x, int idx) {
        search(y, x, idx % 4);
        search(y, x, (idx + 1) % 4);
    }


    private static void cctv_4(int y, int x, int idx) {
        for (int i = 0; i < 4; i++) {
            if (i != idx) {
                search(y, x, i);
            }
        }
    }

    private static void cctv_5(int y, int x, int idx) {
        for (int i = 0; i < 4; i++) {
            search(y, x, i);
        }
    }
}
