package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P035_BJ2839_설탕배달_divide {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (n >= 0) {
            if (n % 5 == 0) {
                int div = n / 5;
                cnt += div;
                n %= 5;
                System.out.println(cnt);
                break;
            }
            n -= 3;
            cnt++;
        }
        if (n != 0) System.out.println(-1);

    }
}
