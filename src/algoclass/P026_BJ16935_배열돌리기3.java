package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P026_BJ16935_배열돌리기3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m, r;
    static int[][] board;
    static int[][] Op3Array;

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        r = array[2];
        StringBuilder sb = new StringBuilder();
        board = new int[n][];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }


        int[] command = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < r; i++) {
            int c = command[i];
            switch (c) {
                case 1:
                    // 상하 반전
                    Operation1();
                    break;
                case 2:
                    //좌우 반전
                    Operation2();
                    break;
                case 3:
                    Operation3();
                    // 오른쪽으로 90도 회전
                    break;
                case 4:
                    Operation4();
                    // 왼쪽으로 90도 회전
                    break;
                case 5:
                    Opreation5();
                    // 부분배열로 나눠서 1-> 2, 2 -> 3 , 3->4 ,4->1
                    break;
                case 6:
                    // 부분배열로 나눠서 1->4 , 4-> 3 , 3-> 2, 2->1
                    Operation6();
                    break;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }


    private static void Opreation5() {
        int newYSize = board.length;
        int newXSize = board[0].length;
        int y_mid = newYSize / 2;
        int x_mid = newXSize / 2;
        int[][] newBoard = new int[newYSize][newXSize];
        int ny, nx;

        // 1-> 2
        for (int i = 0; i < y_mid; i++) {
            for (int j = 0; j < x_mid; j++) {
                newBoard[i][j + x_mid] = board[i][j];
            }
        }

        // 2- > 3
        for (int i = 0; i < y_mid; i++) {
            for (int j = 0; j < x_mid; j++) {
                newBoard[i + y_mid][j + x_mid] = board[i][j + x_mid];
            }
        }

        // 3->4
        for (int i = 0; i < y_mid; i++) {
            for (int j = 0; j < x_mid; j++) {
                newBoard[i + y_mid][j] = board[i + y_mid][j + x_mid];
            }
        }
        // 4->1
        for (int i = 0; i < y_mid; i++) {
            for (int j = 0; j < x_mid; j++) {
                newBoard[i][j] = board[i + y_mid][j];
            }
        }
        board = newBoard;

    }

    private static void Operation6() {

        int newYSize = board.length;
        int newXSize = board[0].length;

        int y_mid = newYSize / 2;
        int x_mid = newXSize / 2;
        int[][] newBoard = new int[newYSize][newXSize];
        int ny, nx;

        // 1->4
        for (int i = 0; i < y_mid; i++) {
            for (int j = 0; j < x_mid; j++) {
                newBoard[i + y_mid][j] = board[i][j];
            }
        }
        // 4->3
        for (int i = 0; i < y_mid; i++) {
            for (int j = 0; j < x_mid; j++) {
                newBoard[i + y_mid][j + x_mid] = board[i + y_mid][j];
            }
        }
        // 3->2
        for (int i = 0; i < y_mid; i++) {
            for (int j = 0; j < x_mid; j++) {
                newBoard[i][j + x_mid] = board[i + y_mid][j + x_mid];
            }
        }
        // 2->1
        for (int i = 0; i < y_mid; i++) {
            for (int j = 0; j < x_mid; j++) {
                newBoard[i][j] = board[i][j + x_mid];
            }
        }
        board = newBoard;


    }

    private static void Operation1() {
        int newX = board.length;
        int time = newX / 2; // swap 횟수
        for (int i = 0; i < time; i++) {
            int swapLine = newX - 1 - i;
            int[] temp = board[i];
            board[i] = board[swapLine];
            board[swapLine] = temp;
        }
    }

    private static void Operation4() {
        int newYSize = board.length;
        int newXSize = board[0].length;


        int[][] newBoard = new int[newXSize][newYSize];

        for (int j = 0; j < newXSize; j++) {
            for (int i = 0; i < newYSize; i++) {
                newBoard[j][i] = board[i][newXSize - j - 1];
            }
        }
        board = newBoard;

    }

    private static void Operation2() {
        int newY = board[0].length;
        int newX = board.length;
        int time = newY / 2;
        for (int i = 0; i < newX; i++) {
            for (int j = 0; j < time; j++) {
                int swapItem = newY - 1 - j;
                int temp = board[i][j];
                board[i][j] = board[i][swapItem];
                board[i][swapItem] = temp;
            }
        }
    }

    private static void Operation3() {
        int newY = board.length;
        int newX = board[0].length;

        Op3Array = new int[newX][newY]; // 90 rotation
        for (int i = 0; i < newX; i++) {
            for (int j = 0; j < newY; j++) {
                Op3Array[i][j] = board[newY - j - 1][i];
            }
        }
        board = Op3Array;
    }
}

