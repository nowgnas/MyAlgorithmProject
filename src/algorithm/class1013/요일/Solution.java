package algorithm.class1013.요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int t, m, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int startDay = 4;
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            int daySub = 0;
            for (int j = m - 1; j >= 1; j--) {
                if (j == 2) {
                    daySub += 29;
                } else if (j == 1 || j == 3 || j == 5 || j == 7 || j == 8 || j == 10 || j == 12) {
                    daySub += 31;
                } else {
                    daySub += 30;
                }
            }
            daySub += d - 1;
            int dayRes = (startDay + daySub) % 7;
            System.out.println("#" + i + " " + dayRes);
        }
    }
}
// 요일 + 경과일을 알면 요일을 알 수 있다 !
// ( 해당 요일을 나타내는 숫자 + 경과일 ) %7 = 요일이 나온다