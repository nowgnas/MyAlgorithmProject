package kang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리2 {

    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder(); // 시간초과날때 .. 쓰는 출력방법

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = 100; // 100*100 2차원 배열을 주기위해

        for (int tc = 1; tc <= 10; tc++) { //10 개의 test case 돌린다
            int x = 0; // 도착 지점 index를 받기 위한 변수
            int y = 0;

            int[][] map = new int[N][N];
            int test = Integer.parseInt(bf.readLine()); // test case 번호 ..

            for (int i = 0; i < N; i++) { // 배열의 크기만큼 입력을 받기
                String s = bf.readLine();
                StringTokenizer st = new StringTokenizer(s, " "); // 공백 기준으로 잘라서
                for (int j = 0; j < N; j++) { //Integer 바꾸기
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] == 2) { // 입력과 동시에 도착지점 좌표 저장하기
                        x = i;
                        y = j;
                    }
                }
            } // 입력 완료 !

            // 방향 좌측 우측 위쪽 ..
            int[] dx = {0, 0, -1};
            int[] dy = {-1, 1, 0};

            while (x != 0) { // x == 0 종료 조건
                for (int i = 0; i < dx.length; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < map.length && ny >= 0 && ny < map.length) {
                        if (map[nx][ny] == 1) { //이동할 수 있으면 방향을 바꾸기 위해 좌표도 바꿔줌
                            x = nx;
                            y = ny;
                            map[x - dx[i]][y - dy[i]] = -1; // 방문처리
                        }
                    } else continue; // 배열을 벗어나는 경우 넘어감
                }
            }
            stringBuilder.append("#").append(tc).append(" ").append(y).append("\n");
        }
        System.out.println(stringBuilder);
    }
}