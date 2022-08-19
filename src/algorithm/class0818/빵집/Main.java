package algorithm.class0818.빵집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.acmicpc.net/problem/3109
 * */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C; // R X C 선언
    static String[][] table; // 전체 테이블 string
    static boolean[][] visited; // 방문 확인 테이블
    static int[] inputs; // 입력 숫자 R, C 저장
    static int[] dy = {-1, 0, 1}; // 오른쪽 위 , 오른쪽, 오른쪽 아래
    static int[] dx = {1, 1, 1}; // x 는 모두 1
    static boolean check, flag; // flag 는 마지막 행에 도착 여부 확인을 위해
    static int cnt; // 파이프 생성되는 개수 세기

    public static void main(String[] args) throws IOException {
        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // int 입력으로 받기
        R = inputs[0];
        C = inputs[1];
        table = new String[R][C]; // 지도? 초기화
        visited = new boolean[R][C]; // 방문 테이블 boolean 으로 초기화

        for (int i = 0; i < R; i++) { // 지도 입력 받기
            table[i] = br.readLine().split("");
        } // 입력 끝

        // -----------지도 잘 만들었는지 출력용-----------
        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(table[i]));
        }// --------------------------------------------

        // 1행에서 출발하기
        for (int i = 0; i < R; i++) {
            visited[i][0] = true; // 시작하는 좌표는 방문 처리
            dfs(i, 0); // 1행에서 시작
        }

        System.out.println(cnt); // 정답 출력

        // -----------방문 테이블 출력용-----------
        for (int i = 0; i < visited.length; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }// --------------------------------------------
    }

    private static void dfs(int y, int x) { // dfs 시작
        if (x == C - 1) { // 마지막 행에 도착하면
            cnt += 1; // 파이프 생성된 것이므로, +1
            flag = true; // flag 는 true
            return; // 반환
        }
        flag = false;
        for (int i = 0; i < 3; i++) { // 3가지 방향으로 돌면서
            int ny = y + dy[i]; // 다음 넘어갈 ny
            int nx = x + dx[i]; // 다음 넘어갈 nx

            if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue; // 테이블을 벗어났을 때 다음 좌표
            if (visited[ny][nx] || table[ny][nx].equals("x")) continue; // 지도에서 x를 만났을 때 다음 좌표

            visited[ny][nx] = true; // 다음 좌표 갈 수 있으니까 true
            dfs(ny, nx); // 다음 좌표로 들어가기
            if (flag) visited[ny][nx] = true; // flag 가 true면 도착한 것이므로 돌아갈 때 false를 주지 않음
            else visited[ny][nx] = false; // flag가 false면 연결을 못한 것이므로 false 로 되돌려 줌
        }
    }
}

/*

5 5
.xx..
..x..
.....
...x.
...x.

*/