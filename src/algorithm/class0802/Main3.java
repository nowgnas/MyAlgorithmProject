package algorithm.class0802;

import java.util.Scanner;

public class Main3 {
    public static boolean distance(int a, int b, int mid) {
        return Math.abs(a - mid) + Math.abs(b - mid) <= mid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int table = sc.nextInt();
            int mid = table / 2;
            int[][] arr = new int[table][table];

            // 테이블 입력 받기
            for (int j = 0; j < table; j++) {
                String[] line = sc.next().split("");
                for (int k = 0; k < table; k++) {
                    arr[j][k] = Integer.parseInt(line[k]);
                }
            }

            int result = 0;
            for (int j = 0; j < table; j++) {
                for (int k = 0; k < table; k++) {
                    if (distance(j, k, mid)) {
                        result += arr[j][k];
                    }
                }
            }
            System.out.println("#" + (i + 1) + " " + result);
        }
    }
}
/*

1
5
14054
44250
02032
51204
52212

1
3
123
456
789

*/