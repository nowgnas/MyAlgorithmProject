package study.week8.구슬탈출2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<int[]> vistied;
    static BufferedReader br;
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        int rX = 0, rY = 0, bX = 0, bY = 0;
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = line[j];
                if (map[i][j] == 'B') {
                    bX = i;
                    bY = j;
                }
                if (map[i][j] == 'R') {
                    rX = i;
                    rY = j;
                }
            }
        }
        vistied = new ArrayList<>();
        System.out.println(bfs(rX, rY, bX, bY));
    }

    static int bfs(int rX, int rY, int bX, int bY) {
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{rX, rY, bX, bY});
        vistied.add(new int[]{rX, rY, bX, bY});

        while (!queue.isEmpty()) {
            cnt++;
            if (cnt > 10) return -1; // 10회를 넘어가게 되면 -1을 출력

            for (int i = 0; i < queue.size(); i++) {
                int[] cur = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nrX = cur[0];
                    int nrY = cur[1];
                    int nbX = cur[2];
                    int nbY = cur[3];

                    boolean rHole = false; // 홀에 들어갔는지 확인
                    boolean bHole = false;

                    int rMove = 0; // 구슬 움직인 횟수
                    int bMove = 0;

                    while (true) {
                        // 빨간 구슬 이동하기
                        rMove++;
                        nrX += dx[j];
                        nrY += dy[j];
                        if (map[nrX][nrY] == 'O') {
                            rHole = true;
                            break;
                        }
                        if (map[nrX][nrY] == '#') {
                            nrX -= dx[j];
                            nrY -= dy[j];
                            break;
                        }
                    }
                    while (true) {
                        // 파란 구슬
                        bMove++;
                        nbX += dx[j];
                        nbY += dy[j];
                        if (map[nbX][nbY] == 'O') {
                            bHole = true;
                            break;
                        }
                        if (map[nbX][nbY] == '#') {
                            nbX -= dx[j];
                            nbY -= dy[j];
                            break;
                        }
                    }
                    if (bHole) continue; // 파란 공이 들어가면 끝
                    if (rHole) return cnt; // 빨간 공이 들어가면 횟수 반환

                    if (nbX == nrX && nrY == nbY) {
                        // 구슬이 같은 위치인 경우
                        if (rMove < bMove) {
                            // 파란 공이 더 많이 움직였으면 늦게 도착한 것 반대 방향으로 한칸 이동
                            nbX -= dx[j];
                            nbY -= dy[j];
                        } else {
                            // 빨간 공이 더 많이 움직였으면
                            nrX -= dx[j];
                            nrY -= dy[j];
                        }
                    }

                    if (check(nrX, nrY, nbX, nbY)) {
                        queue.add(new int[]{nrX, nrY, nbX, nbY});
                        vistied.add(new int[]{nrX, nrY, nbX, nbY});
                    }
                }
            }
        }
        return -1;
    }

    static boolean check(int rx, int ry, int bx, int by) {
        for (int[] a :
                vistied) {
            if (a[0] == rx && a[1] == ry && a[2] == bx && a[3] == by) return false;
        }
        return true;
    }
}
