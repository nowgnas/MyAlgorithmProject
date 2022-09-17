package study.week6.인구이동;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, l, r;
    static int[][] map, direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료

        int count = 0; // 인구이동 카운트
        while (true) { // 이동할 인구가 없을 때까지
            boolean[][] visited = new boolean[n][n]; // 방문 처리 배열 초기화
            boolean flag = false; // 이동 인구 있는지 없는지 여부

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) continue; // 방문한 적 있으면 다음 좌표 보기
                    int set = bfs(i, j, visited); // bfs 탐색 -> 나라 개수 반환
                    if (set >= 2) { // 2개 이상이면 인구 이동이 있는 경우
                        flag = true; // 인구 이동 여부 true
                    }
                }
            }
            if (!flag) break; // 모든 bfs가 끝나도 flag가 false이면 인구이동 할 나라가 없음 -> 탈출
            count++;
        }
        System.out.println(count);
    }

    static int bfs(int y, int x, boolean[][] visited) {
        Queue<Node> q = new ArrayDeque<>(); // bfs를 위한 큐
        Queue<Node> queue = new ArrayDeque<>(); // 한 그룹의 나라를 모두 저장할 큐

        // 두 큐에 초기 값 저장
        q.add(new Node(y, x));
        queue.add(new Node(y, x));

        visited[y][x] = true; // 초기값 방문 처리

        int total = map[y][x]; // 처음 값 더해주기
        int cnt = 1; // 초기값부터 세야 하므로 1로 설정

        while (!q.isEmpty()) { // bfs용 큐가 모두 빌 때까지
            Node cur = q.poll();
            int cy = cur.y;
            int cx = cur.x;

            for (int i = 0; i < 4; i++) {
                int ny = cy + direction[i][0];
                int nx = cx + direction[i][1];
                if (checkMap(ny, nx)) { // 범위 내인 경우
                    if (visited[ny][nx]) continue; // 방문한 경우 다음 값으로
                    int diff = Math.abs(map[cy][cx] - map[ny][nx]); // 현재 나라와 다음 갈 나라의 인구수 차이 계산
                    if (diff < l || diff > r) continue; // 주어진 범위 밖이면 다음값으로

                    // 다음 값을 두 큐에 저장
                    q.add(new Node(ny, nx));
                    queue.add(new Node(ny, nx));

                    total += map[ny][nx]; // 한 그룹의 총 합
                    visited[ny][nx] = true; // 다음 좌표 방문 처리
                    cnt++; // 한 그룹의 나라 개수
                }

            }
        }
        // while 문 완료 된 후
        if (cnt == 1) { // cnt가 1이면 초기값 외에 추가 되지 않으므로 0 반환
            return 0;
        } else { // 한 그룹의 평균을 구하고 지도에 갱신
            int avg = total / cnt;
            while (!queue.isEmpty()) { // 나라를 저장한 큐를 하나씩 꺼내면서 지도에 갱신
                Node cur = queue.poll();
                map[cur.y][cur.x] = avg;
            }
        }
        return cnt; // 나라 개수 반환
    }

    static boolean checkMap(int y, int x) { // 주어진 배열을 벗어나는지 확인
        return y >= 0 && x >= 0 && y < n && x < n; // 범위 내 true 밖 false
    }

    static class Node { // Node 클래스 선언
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}