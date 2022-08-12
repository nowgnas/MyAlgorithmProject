package algorithm.class0812.치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final List<int[]> chicken = new ArrayList<>();
    private static final List<int[]> home = new ArrayList<>();
    private static int[] visit;
    private static int m;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = array[0];
        m = array[1];
        int[][] board = new int[n][];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 치킨집과 집의 인덱스를 저장해놓는다.

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                } else if (board[i][j] == 1) {
                    home.add(new int[]{i, j});
                }
            }
        }
        visit = new int[chicken.size()];
        combination(0, 0);
        System.out.println(answer);

    }


    // 조합을 만들음
    private static void combination(int count, int start) {
        if (count > m) {
            return;
        }

        // 조합 개수가 충족이 되면 치킨 거리 계산
        if (count == m) {
            CalcChickenDist();
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                combination(count + 1, i + 1);
                visit[i] = 0;
            }
        }
    }


    // 각 치킨집 조합마다 치킨 거리를 계산
    private static void CalcChickenDist() {

        int CityChickenDist = 0;

        //각 집에서 조합에 있는 치킨집까지의 치킨거리를 계산한다.
        for (int[] h : home) {
            int hy, hx;
            hy = h[0];
            hx = h[1];
            int maxValue = Integer.MAX_VALUE;
            for (int i = 0; i < chicken.size(); i++) {
                if (visit[i] == 1) {
                    int cy, cx;
                    cy = chicken.get(i)[0];
                    cx = chicken.get(i)[1];

                    int dist = Math.abs(cy - hy) + Math.abs(cx - hx);
                    maxValue = Math.min(dist, maxValue);
                }
            }

            CityChickenDist += maxValue;
        }


        //도시의 치킨거리 값을 답과 비교한다.
        answer = Math.min(answer, CityChickenDist);

    }
}
