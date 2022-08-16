package youtubeclass.class0816.squarenumber;

import java.util.Scanner;

public class Main {
    static int calCnt1, calCnt2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(exp1(x, n));
        System.out.println(calCnt1);

        System.out.println(exp2(x, n));
        System.out.println(calCnt2);


    }

    static long exp1(long x, long n) {
        calCnt1++;
        if (n == 1) return x;
        return x * exp1(x, n - 1);
    }

    static long exp2(long x, long n) {
        calCnt2++;
        if (n == 1) return x;
        long y = exp2(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
