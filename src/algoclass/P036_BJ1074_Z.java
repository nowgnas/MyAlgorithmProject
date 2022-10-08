package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P036_BJ1074_Z {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, r, c;

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        r = array[1];
        c = array[2];
        int answer = 0;
        while (r > 1 || c > 1) {
            int p = (int) baseLog(Math.max(r, c), 2);   // r과c의 최댓값보다 작은 2의 가장 큰 거듭제곱 수
            int m = (int) Math.pow(2, p);                    // r과c의 최댓값보다 작은 2의 가장 큰 거듭제곱 수
            int y = r / m;
            int x = c / m;  // 1/ 2 == 0
            answer += (m * m * 2) * y;
            answer += (m * m * x);
            r %= m;
            c %= m;
        }
        if (r == 1 && c == 1) {
            answer += 3;
        } else if (r == 1 && c == 0) {
            answer += 2;
        } else if (r == 0 && c == 1) {
            answer += 1;
        }
        System.out.println(answer);
    }

    static double baseLog(double x, double base) {
        return Math.log(x) / Math.log(base);
    }

}
