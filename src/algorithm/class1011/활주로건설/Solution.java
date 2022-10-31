package algorithm.class1011.활주로건설;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int tc, n, x;
    static int[][] map, map2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            map2 = new int[n][n];


            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    map2[k][j] = map[j][k] = Integer.parseInt(st.nextToken());

                }
            }
            System.out.println("#" + i + " " + process());
        }
    }

    static int process() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (makeRoad(map[i])) count++;
            if (makeRoad(map2[i])) count++;
        }
        return count;
    }

    // 해당 지형 정보로 활주로 건설이 가능하면 true, 불가능하면 false 리턴
    static boolean makeRoad(int[] road) {
        int beforeHeight = road[0], size = 0;
        int j = 0;
        while (j < n) {
            if (beforeHeight == road[j]) { // 동일 높이
                size++;
                j++;
            } else if (beforeHeight + 1 == road[j]) { // 이전높이보다 1 높음: 오르막 경사로 설치 체크
                if (size < x) return false; // x길이 미만이면 설치 불가

                beforeHeight++;
                size = 1;
                j++;
            } else if (beforeHeight - 1 == road[j]) { // 이전 높이 보다 1 작음
                int count = 0;
                for (int i = j; i < n; i++) {
                    if (road[i] != beforeHeight - 1) return false;

                    if (++count == x) break; // 최소 길이 만족
                }
                if (count < x) return false;

                // 길이를 만족하는 상황
                beforeHeight--;
                j += x;
                size = 0;

            } else { // 높이가 2 이상 차이
                return false;
            }
        }
        return true;
    }
}
