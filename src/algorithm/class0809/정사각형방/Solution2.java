package algorithm.class0809.정사각형방;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution2 {
    static int t, n, maxVal, maxCnt, val, X, Y, startIdx, val2, X2, Y2, cnt, minStartIdx;
    static int[] item1;
    static int[] item2;
    static int[][] arr;

    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static PriorityQueue<int[]> queue;
    static PriorityQueue<int[]> answer;
    static int[] result;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        t = Integer.parseInt(br.readLine()); // 테스트 케이스

        // 테스트 케이스 입력 받기 시작
        for (int i = 1; i <= t; i++) {
            n = Integer.parseInt(br.readLine()); // n 입력
            arr = new int[n][n]; // 전체 테이블 입력 받을 배열 초기화
            queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
            maxVal = Integer.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    queue.add(new int[]{arr[j][k], j, k}); // 우선순위 큐 저장 완료
                    if (maxVal < arr[j][k]) maxVal = arr[j][k]; // 최대값 저장
                }
            }// 테이블 입력 완료

            // 로직 시작
            // 4방향을 보긴 봐야 함
            // bfs 사용
            item1 = new int[3];
            item2 = new int[3];

            maxCnt = Integer.MIN_VALUE;
            item1 = queue.remove();
            val = item1[0];
            X = item1[1];
            Y = item1[2];
            startIdx = val;
            answer = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
            cnt = 1;
            int length = 0;

            for (int j = 0; j < n * n - 1; j++) {
                // queue 순서대로 보면서 현재 좌표가 다음 좌표랑 1차이 나는지, 좌표 거리가 1인지 확인
                item2 = queue.remove();

                val2 = item2[0];
                X2 = item2[1];
                Y2 = item2[2];

                if (val2 - val == 1 && Math.abs(X - X2) + Math.abs(Y - Y2) == 1) {
                    X = X2;
                    Y = Y2;
                    val = val2;
                    cnt++;
                } else {
                    answer.add(new int[]{startIdx, cnt});
                    length++;
                    X = X2;
                    Y = Y2;
                    val = val2;
                    startIdx = val;
                    cnt = 1;
                }
            }
            result = new int[length];
            result = answer.remove();
            sb.append("#").append(i).append(" ").append(result[0]).append(" ").append(result[1]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

/*


2
2
1 2
3 4
3
9 3 4
6 1 5
7 8 2

*/