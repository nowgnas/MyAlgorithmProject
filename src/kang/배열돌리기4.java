package kang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 배열돌리기4 {
    static int N, M, K;
    static int[][] arr;
    static int[][] rotation;
    static int[] num; // 연산 정보를 위해
    static boolean[] isSelected;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 행 길이
        M = Integer.parseInt(input[1]); // 열 길이
        K = Integer.parseInt(input[2]); // 연산의 횟수

        arr = new int[N][M]; // 입력받을 배열
        for (int i = 0; i < N; i++) {
            input = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        } // 배열 입력 완료 !

        rotation = new int[K][3]; // 회전 연산 정보를 저장하자

        for (int i = 0; i < K; i++) {
            input = bf.readLine().split(" ");
            rotation[i][0] = Integer.parseInt(input[0]); //r
            rotation[i][1] = Integer.parseInt(input[1]); //c
            rotation[i][2] = Integer.parseInt(input[2]); //s
        }
        num = new int[K]; // 연산정보 r c s 릉 위해
        isSelected = new boolean[K];
        min = Integer.MAX_VALUE;
        // 회전 연산을 수행한 순서에 따라 최종 배열이 다르다 .. 순열 써야된다 !!!!!!!!
        Perm(0);
        System.out.println(min);

    }// main end

    // 순열 컴온
    static void Perm(int cnt) {
        if (cnt == K) {
            int[][] tmp = new int[N][M]; // 복사

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    tmp[i][j] = arr[i][j];
                }
            }
            for (int i = 0; i < K; i++) { // 연산 정보 횟수만큼 돌면서 회전
                int x1 = rotation[num[i]][0] - rotation[num[i]][2] - 1; //r-s
                int y1 = rotation[num[i]][1] - rotation[num[i]][2] - 1; //c-s
                int x2 = rotation[num[i]][0] + rotation[num[i]][2] - 1; //r+s
                int y2 = rotation[num[i]][1] + rotation[num[i]][2] - 1; //c+s

                rotate(x1, y1, x2, y2, tmp);
            }
            Min(tmp);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (isSelected[i]) continue;
            num[cnt] = i;
            isSelected[i] = true;
            Perm(cnt + 1);
            isSelected[i] = false;
        }
    }


    static void rotate(int x1, int y1, int x2, int y2, int[][] tmp) {
        for (int i = x1; i < x2; i++) { // 연산 정보에서 오른쪽 좌표까지만 돌려
            for (int j = y1; j < y2; j++) { // 우 하 좌 상 
                for (int k = y1; k < y2; k++) { // 우
                    System.out.println("hello");
                    tmp[i][j + 1] = arr[i][j];
                }
                for (i = x1; i < x2; i++) { // 하
                    System.out.println("bye");
                    tmp[i + 1][j] = arr[i][j];
                }
                for (j = y1; j > 0; j--) { // 좌
                    System.out.println(" yeah");
                    tmp[i][j - 1] = arr[i][j];
                }
                for (i = x1; i > 0; i--) { //상
                    System.out.println("??");
                    tmp[i - 1][j] = arr[i][j];
                }
            }
        }
    } // rotate end

    static void Min(int[][] tmp) { // 각 행 합의 최소값을 답으로 내기 위해
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += tmp[i][j];
            }
            min = Math.min(min, sum);
        }
    }
}

/*


5 6 2
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
3 4 2
4 2 1

*/