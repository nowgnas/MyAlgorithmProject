package 이상원;
/*
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN
*/

import java.util.Scanner;

public class P001_SWEA1289_원재의메모리복구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int count = 0;
        for (int i = 0; i < tc; i++) {
            String line = sc.next();

            // 알고리즘 시작
            count = 0;
            if (line.startsWith("1")) count += 1;
            for (int j = 0; j < line.length() - 1; j++) {
                if (line.charAt(j) != line.charAt(j + 1)) count += 1;
            }
            System.out.printf("#%d %d\n", i + 1, count);
        }
    }
}
