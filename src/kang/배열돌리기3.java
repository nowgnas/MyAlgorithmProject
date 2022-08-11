package kang;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 배열돌리기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s[] = bf.readLine().split(" ");
        // 배열의 크기 N, M
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        // 연산의 수
        int R = Integer.parseInt(s[2]);

        int[][] map = new int[100][100]; // 입력받는 배열 !
        for (int i = 0; i < N; i++) {
            String s1[] = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s1[j]);
            }
        }
        // 수행해야하는 연산
        int[] tmp = new int[R];
        String s2[] = bf.readLine().split(" ");
        for (int i = 0; i < R; i++) {
            tmp[i] = Integer.parseInt(s2[i]);
        }

        int[][] ans = new int[100][100]; // 답을 저장할 배열 !

        //---------------------------------- 입력 완료 !

        for (int z = 0; z < 3; z++) { // 연산의 수만큼 ..
            int i;
            switch (tmp[z]) { // 수행해야하는 연산을 기준으로  ..
                case 1: // 상하반전
                    for (int x = N - 1; x >= 0; x--) {
                        for (int y = M - 1; y >= 0; y--) {
                            ans[N - x - 1][y] = map[x][y]; // 거꾸로부터 넣기 ...
                        }
                    }
                    break;
                case 2: // 좌우반전
                    for (int x = 0; x < N; x++) {
                        for (int y = 0; y < M; y++) {
                            ans[x][y] = map[x][M - y - 1];
                        }
                    }
                    break;

                case 3: //90도로 회전
                    for (int y = 0, n = 0; y < M; y++, n++) {
                        for (int x = N - 1, m = 0; x >= 0; x--, m++) {
                            ans[n][m] = map[x][y];
                        }
                    }
                    int temp = M;
                    M = N;
                    N = temp;
                    break;
                case 4: // 반90도로 회전 ..
                    for (int y = M - 1, n = 0; y >= 0; y--, n++) {
                        for (int x = 0, m = 0; x < N; x++, m++) {
                            ans[n][m] = map[x][y];
                        }
                    }
                    break;
                case 5:
                    //1->2
                    for (i = 0; i < N / 2; i++) {
                        for (int j = 0; j < M / 2; j++) {
                            ans[i][M / 2 + j] = map[i][j];
                        }
                    }

                    //2->3
                    for (i = 0; i < N / 2; i++) {
                        for (int j = M / 2; j < M; j++) {
                            ans[N / 2 + i][j] = map[i][j];
                        }
                    }

                    //3->4
                    for (i = N / 2; i < N; i++) {
                        for (int j = M / 2, y = 0; j < M; j++, y++) {
                            ans[i][y] = map[i][j];
                        }
                    }

                    //4->1
                    int r = 0;
                    for (i = N / 2; i < N; i++, r++) {
                        for (int j = 0; j < M / 2; j++) {
                            ans[r][j] = map[i][j];
                        }
                    }
                    break;

                case 6:
                    //2->1
                    for (i = 0; i < N / 2; i++) {
                        for (int j = 0; j < M / 2; j++) {
                            ans[i][j] = map[i][M / 2 + j];
                        }
                    }

                    //3->2
                    for (i = 0; i < N / 2; i++) {
                        for (int j = M / 2; j < M; j++) {
                            ans[i][j] = map[N / 2 + i][j];
                        }
                    }

                    //4->3
                    for (i = N / 2; i < N; i++) {
                        for (int j = M / 2, y = 0; j < M; j++, y++) {
                            ans[i][j] = map[i][y];
                        }
                    }

                    //1->4
                    for (i = N / 2, r = 0; i < N; i++, r++) {
                        for (int j = 0; j < M / 2; j++) {
                            ans[i][j] = map[r][j];
                        }
                    }
                    break;

            }//switch end
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    map[j][k] = ans[j][k];
                    ans[j][k] = 0;
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] != 0)
                    System.out.print(map[i][j] + " ");
            }
            if (map[i][0] != 0)
                System.out.println();
        }
    }

}
/*
6 8 1
3 2 6 3 1 2 9 7
9 7 8 2 1 4 5 3
5 9 2 1 9 6 1 8
2 1 3 8 6 3 9 2
1 3 2 8 7 9 2 1
4 5 1 9 8 2 1 3
1


6 8 6
3 2 6 3 1 2 9 7
9 7 8 2 1 4 5 3
5 9 2 1 9 6 1 8
2 1 3 8 6 3 9 2
1 3 2 8 7 9 2 1
4 5 1 9 8 2 1 3
1 2 3 4 5 6

4 5 1 9 8 2 1 3
1 3 2 8 7 9 2 1
2 1 3 8 6 3 9 2
5 9 2 1 9 6 1 8
9 7 8 2 1 4 5 3
3 2 6 3 1 2 9 7

7 9 2 1 3 6 2 3
3 5 4 1 2 8 7 9
8 1 6 9 1 2 9 5
2 9 3 6 8 3 1 2
1 2 9 7 8 2 3 1
3 1 2 8 9 1 5 4

4 1 2 5 9 3 2 3
5 3 1 9 7 2 7 9
1 2 3 2 8 6 9 5
9 8 8 1 2 3 1 2
8 7 6 9 1 1 3 1
2 9 3 6 4 2 5 4
1 2 9 1 5 9
3 1 2 8 3 7

*/