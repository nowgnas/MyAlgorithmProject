package kang;

import java.util.Scanner;

public class P008_SWEA1873_상호의배틀필드 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // test case
        for (int t = 1; t <= T; t++) {
            int H = sc.nextInt(); // 높이
            int W = sc.nextInt(); // 너비
            int x = 0; // 전차 좌표 저장을 위해
            int y = 0;

            String[][] map = new String[H][W];
            for (int i = 0; i < H; i++) {
                map[i] = sc.next().split("");
                for (int j = 0; j < W; j++) {
                    switch (map[i][j]) {
                        case "<":
                        case ">":
                        case "^":
                        case "v":
                            x = i;
                            y = j;
                            break;
                    }
                }
            } // 게임 맵 입력 완료 !

            int N = sc.nextInt(); // 이동 횟수
            String s = sc.next();

            for (int n = 0; n < s.length(); n++) {
                char c = s.charAt(n); // 사용자가 입력한 값을 가지고 ..
                switch (c) {
                    case 'U':
                        if (x > 0 && map[x - 1][y].equals(".")) { // 위로 이동할 수 있는 경우라면
                            map[x][y] = "."; // 지금 자리는 지나오고
                            x--; // 위로 한칸 이동
                            map[x][y] = "^"; // 전차는 위를 바라보게 !
                            break;
                        } else {// 이동할 수 없다면 전차가 바라보는 방향만 바꿔라 !
                            map[x][y] = "^";
                            break;
                        }
                    case 'D':
                        if (x + 1 < H && map[x + 1][y].equals(".")) { // 아래로 이동할 수 있는 경우라면 > 위와 주석 위와 동일
                            map[x][y] = ".";  // 지금 자리는 지나오고
                            x++; // 아래로 이동
                            map[x][y] = "v"; // 전차는 아래를 보게
                            break;
                        } else { // 이동할 수 없다면 전차가 바라보는 방향만 바꾸기
                            map[x][y] = "v";
                        }
                        break;
                    case 'L':
                        if (y > 0 && map[x][y - 1].equals(".")) {  // 왼쪽로 이동할 수 있는 경우라면
                            map[x][y] = "."; // 지금 자리는 지나오고
                            y--; // 왼쪽으로 이동
                            map[x][y] = "<"; // 전차는 왼쪽을 바라보게
                            break;
                        } else {
                            map[x][y] = "<"; // 이동할 수 없다면 전차가 바라보는 방향만 바꾸기
                        }
                        break;
                    case 'R':
                        if (y + 1 < W && map[x][y + 1].equals(".")) {  // 오른쪽로 이동할 수 있는 경우라면
                            map[x][y] = "."; //지금 자리는 지나오고
                            y++; // 오른쪽으로 한칸 이동
                            map[x][y] = ">"; // 전차는 오른쪽을 바라보게
                            break;
                        } else {
                            map[x][y] = ">"; // 이동할 수 없다면 전차가 바라보는 방향만 바꾸기
                        }
                        break;

                    case 'S': // 포탄 ... 하
                        switch (map[x][y]) { // 현재 포차의 방향을 기준으로 !
                            case "^": // 위쪽을 바라보고 있을때 쏘면 ?
                                for (int d = x; d >= 0; d--) { // 위쪽으로 벽돌벽인지 강철인벽인지를 만날때까지 ..
                                    if (map[d][y].equals("*")) { // 만약 벽돌벽인경우
                                        map[d][y] = "."; // 평지로 바꾸어주고
                                        break;
                                    } else if (map[d][y].equals("#")) { // 강철로 된 벽을 만나는 경우 아무일도 없서..
                                        break;
                                    }
                                }
                                break;

                            case "v": // 아래쪽을 바라보고 있을때 쏘면 ? 위 주석과 동일 ..
                                for (int d = x; d < H; d++) {
                                    if (map[d][y].equals("*")) { // 만약 벽돌벽인경우
                                        map[d][y] = "."; // 평지로 바꾸어주고
                                        break;
                                    } else if (map[d][y].equals("#")) { // 강철로 된 벽을 만나는 경우 아무일도 없서..
                                        break;
                                    }
                                }
                                break;

                            case "<": // 왼쪽을 바라보고 있을때 쏘면 ?
                                for (int d = y; d >= 0; d--) {
                                    if (map[x][d].equals("*")) { // 만약 벽돌벽인경우
                                        map[x][d] = "."; // 평지로 바꾸어주고
                                        break;
                                    } else if (map[x][d].equals("#")) { // 강철로 된 벽을 만나는 경우 아무일도 없서..
                                        break;
                                    }
                                }
                                break;

                            case ">": // 오른쪽을 바라보고 있을때 쏘면 ?
                                for (int d = y; d < W; d++) {
                                    if (map[x][d].equals("*")) { // 만약 벽돌벽인경우
                                        map[x][d] = "."; // 평지로 바꾸어주고
                                        break;
                                    } else if (map[x][d].equals("#")) { // 강철로 된 벽을 만나는 경우 아무일도 없서..
                                        break;
                                    }
                                }
                                break;

                        }
                }
            }
            System.out.print("#" + t + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }


        }
    } //Main end

}
