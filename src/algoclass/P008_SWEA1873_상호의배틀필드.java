package 이상원;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class P008_SWEA1873_상호의배틀필드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // test case
        String[] head = {"<", ">", "^", "v"};

        for (int i = 0; i < tc; i++) {
            // each test case
            int h = sc.nextInt(); // 높이 h
            int w = sc.nextInt(); // 너비 w
            String[][] game = new String[h][w];
            int x = 0, y = 0;

            for (int j = 0; j < h; j++) {
                game[j] = sc.next().split("");
                for (int k = 0; k < 4; k++) {
                    if (Arrays.asList(game[i]).contains(head[j])) {
                        x = i; // 시작 전차 x좌표
                        y = Arrays.asList(game[i]).indexOf(head[j]); // 시작 전차 y좌표
                    }
                }
            }
            int command = sc.nextInt();
            String[] commandList = sc.next().split("");
            for (int j = 0; j < command; j++) {
                switch (commandList[j]) {
                    case "U":
                        // 위로 가기
                        if (x - 1 < 0) {// 위가 지도 밖이면 다음 명령어
                            game[x][y] = "^"; // 방향 위로 보기
                            continue;
                        }
                        if (Objects.equals(game[x - 1][y], ".")) { // 위가 평지(.)일때
                            game[x - 1][y] = "^"; // 위 좌표를 ^로 변경
                            x--; // x 위치 하나 줄여서 변경
                        }
                        break;
                    case "D":
                        // 아래로 가기
                        if (x + 1 >= h) { // 아래가 지도 밖이면
                            game[x][y] = "v"; // 방향 아래로 보고 break
                            continue;
                        }
                        if (Objects.equals(game[x + 1][y], ".")) { // 아래가 평지 . 일 때
                            game[x + 1][y] = "v";
                            x++;
                        }
                        break;
                    case "L":
                        // 왼쪽으로 가기
                        if (y - 1 < 0) { // 왼쪽이 지도 밖이면
                            game[x][y] = "<";
                            continue;
                        }
                        if (Objects.equals(game[x][y - 1], ".")) { // 왼쪽이 평지 . 일 때
                            game[x][y - 1] = "<";
                            y--;
                        }
                        break;
                    case "R":
                        // 오른쪽으로 가기
                        if (y + 1 >= w) { // 오른쪽이 지도 밖이면
                            game[x][y] = ">";
                            continue;
                        }
                        if (Objects.equals(game[x][y + 1], ".")) {
                            game[x][y + 1] = ">";
                            y++;
                        }
                        break;
                    case "S":
                        // 포탄 쏘기
                        switch (game[x][y]) {
                            case "<":

                                break;
                            case "^":
                                break;
                            case ">":
                                break;
                            case "v":
                                break;

                        }
                        break;
                }

            }
        }


    }

}
