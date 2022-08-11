package algorithm.class0803.배틀필드.withstatic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

/*
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc

*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int p = 0; p < tc; p++) {
            int[] hw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int h = hw[0]; // 높이 h
            int w = hw[1]; // 너비 w
            int x = 0;
            int y = 0;
            String[] head = {"<", ">", "^", "v"};

            String[][] game = new String[h][w];
            for (int i = 0; i < h; i++) {
                String[] mapLine = br.readLine().split("");
                for (String s : head) {
                    if (Arrays.asList(mapLine).contains(s)) { // 전차가 있으면
                        x = i;
                        y = Arrays.asList(mapLine).indexOf(s); // 전차 인덱스 받아오기
                    }
                }
                game[i] = mapLine;
            } // 지도 입력 받기 완료

            // 명령 횟수
            int command = Integer.parseInt(br.readLine());
            // 명령 command 받기
            String[] commandList = br.readLine().split("");

            // 명령 switch
            for (int i = 0; i < command; i++) {
                switch (commandList[i]) { // 명령에 따른 동작
                    case "U": // 위로 가기
                        if (x - 1 >= 0 && Objects.equals(game[x - 1][y], ".")) {
                            game[x][y] = ".";
                            x--;
                        }
                        game[x][y] = "^";
                        break;
                    case "D":
                        if (x + 1 < h && game[x + 1][y] == ".") {
                            game[x][y] = ".";
                            x++;
                        }
                        game[x][y] = " ";
                        break;

                    case "L":
                        if (y > 0 && Objects.equals(game[x][y - 1], ".")) { // 왼쪽이 . 이면 간다
                            game[x][y] = ".";
                            y--;
                        }
                        game[x][y] = "<"; // 이동한 좌표에 전차 방향 설정
                        break;
                    case "R":
                        if (y + 1 < w && Objects.equals(game[x][y + 1], ".")) { // 오른쪽이 .이면 간다
                            game[x][y] = ".";
                            y++;
                        }
                        game[x][y] = ">"; // 이동한 좌표에 전차 방향 설정
                        break;
                    case "S":
                        switch (game[x][y]) { // 전차가 보고 있는 방향에 따라
                            case "^": // 위로 보고 있으면
                                for (int j = x; j >= 0; j--) { // x index 위로
                                    if (Objects.equals(game[j][y], "#")) { // 강철 벽, 맵 밖이면 탈출
                                        break;
                                    } else if (Objects.equals(game[j][y], "*")) {
                                        game[j][y] = "."; // 벽돌이면 평지
                                        break;
                                    }
                                }
                            case ">": // 오른쪽으로 보고 있으면
                                for (int j = y; j < w; j++) {
                                    if (Objects.equals(game[x][j], "#")) { // 강철 벽 만나면
                                        break;
                                    } else if (Objects.equals(game[x][j], "*")) {
                                        game[x][j] = ".";
                                        break;
                                    }
                                }
                            case "v": // 아래로 보고 있으면
                                for (int j = x; j < h; j++) {
                                    if (Objects.equals(game[j][y], "#")) {
                                        break;
                                    } else if (Objects.equals(game[j][y], "*")) {
                                        game[j][y] = ".";
                                        break;
                                    }
                                }
                            case "<": // 왼쪽으로 보고 있으면
                                for (int j = y; j >= 0; j--) {
                                    if (Objects.equals(game[x][j], "#")) break;
                                    else if (Objects.equals(game[x][j], "*")) {
                                        game[x][j] = ".";
                                        break;
                                    }
                                }
                        }
                }
            }
            sb.append("#").append((p + 1)).append(" ");
            for (String[] line :
                    game) {
                String answerLine = String.join("", line);
                sb.append(answerLine).append("\n");
            }
        }
        System.out.print(sb);
    }
}

/*

1
3 7
***....
*-..#**
#<.****
23
SURSSSSUSLSRSSSURRDSRDS

*/