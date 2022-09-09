package study.week5.경주로건설;

import java.util.Queue;
import java.util.LinkedList;


public class Solution4 {
    static int[][][] price;
    static int N;
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static int[][] board = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 0}
    };

    public static void main(String[] args) {


        N = board.length;
        price = new int[4][N][N]; // 방향, 행, 열
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                price[0][i][j] = Integer.MAX_VALUE;
                price[1][i][j] = Integer.MAX_VALUE;
                price[2][i][j] = Integer.MAX_VALUE;
                price[3][i][j] = Integer.MAX_VALUE;
            }
        }
        // bfs 큐
        Queue<int[]> q = new LinkedList<>();
        // 1, 0을 갈 수 있으면
        // 아래방향 가격에 100 추가 후 큐에 넣기
        if (board[1][0] == 0) {
            price[1][1][0] = 100;
            q.add(new int[]{1, 0, 1}); // x, y, 방향
        }
        // 오른쪽 방향 갈 수 있으면
        // 오른쪽 방향에 100 추가 후 큐에 넣기
        if (board[0][1] == 0) {
            price[3][0][1] = 100;
            q.add(new int[]{0, 1, 3});
        }

        // bfs 큐가 빌 때까지
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cRow = cur[0]; // x
            int cCol = cur[1]; // y
            int cDir = cur[2]; // 방향

            for (int nDir = 0; nDir < 4; nDir++) {
                // 다음 갈 방향
                int nRow = cRow + move[nDir][0];
                int nCol = cCol + move[nDir][1];

                // 지도에 1이거나 범위 벗어나면 다음 좌표
                if (!isInRange(nRow, nCol) || board[nRow][nCol] == 1) continue;
                if (cDir != nDir) { // 방향이 달라질 경우
                    if (cDir + nDir == 1 || cDir + nDir == 5) continue; // 역방향으로 돌아가면 넘기기
                    if (price[nDir][nRow][nCol] < price[cDir][cRow][cCol] + 600) continue; // 다음 좌표가 더 크면 다음 좌표로 넘기기
                    q.add(new int[]{nRow, nCol, nDir}); // 작으면 추가
                    price[nDir][nRow][nCol] = price[cDir][cRow][cCol] + 600; // 비용 지도에 추가
                } else { // 직선으로 갈 경우
                    if (price[nDir][nRow][nCol] < price[cDir][cRow][cCol] + 100) continue; // 다음 좌표가 더 크면 다음 좌표로 넘기기
                    q.add(new int[]{nRow, nCol, nDir}); // 아니면 추가
                    price[nDir][nRow][nCol] = price[cDir][cRow][cCol] + 100; // 비용 지도에 추가
                }
            }
        }

        int result = Integer.MAX_VALUE; // 결과 초기화
        for (int i = 0; i < 4; i++) {
            // N-1, N-1에 네 방향에 저장된 값들 중 작은값이 답이다.
            result = (Math.min(result, price[i][N - 1][N - 1]));
        }
        System.out.println(result);
    }

    static Boolean isInRange(int row, int col) {
        // 범위 벗어나는지 체크
        if (row < 0 || row >= N || col < 0 || col >= N) return false;
        return true;
    }
}