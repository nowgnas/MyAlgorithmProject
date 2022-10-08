package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P065_BJ1149_RGB거리 {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int[][] map;
    static int[] result;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][3];
        result = new int[3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료

        for (int i = 0; i < 3; i++) {
            result[i] += map[0][i]; // rgb 1차원 배열
            selectColor(i, i, 1); // 집을 선택하기
            System.out.println("-----------");
        }
        System.out.println(Arrays.toString(result));
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < result.length; i++) {
            answer = Math.min(answer, result[i]);
        }
        System.out.println(answer);

    }

    static void selectColor(int nowidx, int idx, int row) {
        int minVal = Integer.MAX_VALUE; // rgb중 최소값
        int newIdx = 0;
        for (int i = 0; i < 3; i++) {
            if (idx == i) continue;
            if (minVal > map[row][i]) { // 이전 index와 같지 않고 작은 값인 경우 추가
//                System.out.println("selected: " + i + " " + map[row][i]);
                minVal = map[row][i]; // 최소값 갱신
                newIdx = i; // 최소값을 가진 index 갱신
            }
        }
        result[nowidx] += minVal; // 출발한 인덱스에 비용 추가
        System.out.println(result[nowidx]);
        if (row == n - 1) return; // 마지막 행인 경우 종료
        selectColor(nowidx, newIdx, row + 1); // 출발 index , 집에 칠한 index, 행 +1 로 재귀
    }
}

/*
71 127 94
145 108 134
197 163 208
246 255 174
239 187 261
234 264 216
276 282 253
*/