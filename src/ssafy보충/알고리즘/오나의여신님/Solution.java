package ssafy보충.알고리즘.오나의여신님;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            super();
            this.y = y;
            this.x = x;
        }
    }

    static int[] dx = {-1, 1, 0, 0}; // 상 하 우 좌
    static int[] dy = {0, 0, -1, 1};
    static int r, c;
    static char[][] graph;
    static char[][] visited;
    static int time;

    static Queue<Node> soo; // 수연이
    static Queue<Node> dev; // 악마

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String[] s = bf.readLine().split(" ");
            r = Integer.parseInt(s[0]);
            c = Integer.parseInt(s[1]); // R행  C열

            visited = new char[r][c];
            graph = new char[r][c];

            soo = new LinkedList<Node>();
            dev = new LinkedList<Node>();


            for (int i = 0; i < r; i++) {
                String st = bf.readLine();
                for (int j = 0; j < c; j++) {
                    graph[i][j] = st.charAt(j);

                    if (graph[i][j] == '*') { // 악마
                        visited[i][j] = 'x'; // 이동 처리
                        dev.offer(new Node(i, j));
                    } else if (graph[i][j] == 'D') { // 도착지점
                        visited[i][j] = 'g';
                    } else if (graph[i][j] == 'X') { // 돌
                        visited[i][j] = 'x';
                    } else if (graph[i][j] == '.') { // 이동이 가능한 경우
                        visited[i][j] = 'p';
                    } else { // 수연이
                        graph[i][j] = '.';
                        visited[i][j] = 'x';
                        soo.offer(new Node(i, j));
                    }
                }
            } // 입력 완료 !

            bfs(); // 악마 놓고 수연이 이동

            if (time == -1) System.out.println("#" + tc + " " + "GAME OVER"); // 이동을 못하는 경우라면 ..
            else System.out.println("#" + tc + " " + time); // 만약 이동 가능하면 그 이동 시간
        }

    }

    // 최소 시간으로 이동
    static void bfs() {
        for (time = 1; ; time++) { // 시간에 따라
            // 악마 퍼지고 수연이 이동
            int devsize = dev.size();
            for (int i = 0; i < devsize; i++) {
                Node cur = dev.poll();

                for (int d = 0; d < 4; d++) { // 4 방향으로 탐색 !
                    int nx = cur.y + dx[d];
                    int ny = cur.x + dy[d];

                    if (0 > nx || 0 > ny || nx >= r || ny >= c) continue; // 범위를 벗어나는 경우

                    // 범위내 존재하는 경우
                    if (graph[nx][ny] == '.') { // 이동이 가능하다면 !?
                        graph[nx][ny] = '*'; // 그 칸을 물로 채운다
                        dev.add(new Node(nx, ny));
                    }

                }

            }
            // 고슴도치 이제 이동 !
            int sooSize = soo.size();
            if (sooSize == 0) {
                time = -1;
                return;
            }

            for (int i = 0; i < sooSize; i++) {
                Node cur = soo.poll();

                for (int d = 0; d < 4; d++) { // 4 방향으로 탐색 !
                    int nx = cur.y + dx[d];
                    int ny = cur.x + dy[d];

                    if (0 > nx || 0 > ny || nx >= r || ny >= c) continue;
                    //  도착 지점에 도착한 경우
                    if (graph[nx][ny] == 'D') return;

                    if (graph[nx][ny] == '.' && visited[nx][ny] == 'p') {
                        visited[nx][ny] = 'X'; // 방문처리하고 이동 !
                        soo.add(new Node(nx, ny));
                    }
                }
            }

        }// 시간 순으로 확인

    } // bfs end
}