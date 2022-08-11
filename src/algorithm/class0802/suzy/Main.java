package algorithm.class0802.suzy;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) { //test case

            int N = sc.nextInt(); // 농장 크기
            int[][] farm = new int[N][N];

            for (int j = 0; j < N; j++) {
                String[] line = sc.next().split("");
                for (int k = 0; k < N; k++) {
                    farm[j][k] = Integer.parseInt(line[k]);
                }
            } // 농작물 입력 받기

            int sum = 0; // 수익

            if (N == 1) { // 농장의 크기가 1인 경우
                sum = farm[0][0];
            }
            // 마름모 모양으로 돌며 다 더해주면 된다 !
            else {
                int midx = N / 2; // 가운데를 중심으로
                int midy = N / 2;

                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        if (Math.abs(midx - x) + Math.abs(midy - y) <= N / 2) {
                            sum += farm[x][y];
                        }
                    }
                }
            }
            System.out.println(sum);
        }
    }

}

/*

1
3
123
456
789

*/