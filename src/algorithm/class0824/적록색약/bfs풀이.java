package algorithm.class0824.적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bfs풀이 {
    static int N;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}; // 하 상 우 좌
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(bf.readLine()); // N*N

        graph = new char[N][N]; // 구역을 입력받을 배열

        for (int i = 0; i < N; i++) {
            String st = bf.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = st.charAt(j);
            }
        } // 입력완료

        // 적록 색약이 아닌 사람은 다 세어주면 된다
        // 적록 색약인 사람은 RG 같은걸로

        int cnt = 0; // 적록색약이 아니신분
        visited = new boolean[N][N]; // 그냥 0으로 초기화 됩
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        } //돌면서 ..

        sb.append(cnt).append(" ");


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 'G') { // 빨강이면 초록이랑 같은 것
                    graph[i][j] = 'R'; // 빨강이면 초록으로 다 바꾸고
                }
            }
        } //돌면서 ..
        cnt = 0;
        visited = new boolean[N][N]; // 그냥 0으로 초기화 됩
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        } //돌면서 ..
        sb.append(cnt);

        System.out.println(sb);
    } // main end

    static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int d = 0; d < 4; d++) { // 4 방향으로 탐색 !
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if (0 <= nx && 0 <= ny && nx < N && ny < N && !visited[nx][ny] && graph[curX][curY] == graph[nx][ny]) { // 범위 내에 존재한다면
                    visited[nx][ny] = true; // 방문처리하고 이동 !
                    q.offer(new int[]{nx, ny});
                }
            } // bfs end
        }
    }
}