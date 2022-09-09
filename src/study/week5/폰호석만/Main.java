package study.week5.폰호석만;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String xA, xB, x, max;
    static long a, b;
    static int count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        xA = s[0];
        xB = s[1];
        max = String.valueOf(Math.pow(2, 63));

        arr = new int[200];

        for (int i = 0; i < 9; i++) {
            arr[i + '1'] = i + 1;
        }
        for (int i = 0; i < 26; i++) {
            arr['a' + i] = i + 10;
        }
        solve();

        if (count == 0) {
            System.out.println("Impossible");
        } else if (count == 1) {
            String toInteger = x.substring(0, x.length() - 2);
            System.out.println(toInteger + " " + a + " " + b);
        } else {
            System.out.println("Multiple");
        }
    }

    public static void solve() {
        for (int i = 1; i <= 36; i++) {
            for (int j = 1; j <= 36; j++) {
                if (i == j) {
                    continue;
                }
                if (check(i, xA) && check(j, xB)) {
                    if (find(i, xA).equals(find(j, xB))) {
                        if (find(i, xA).compareTo(max) >= 1) {
                            continue;
                        }
                        count++;
                        x = find(i, xA);
                        a = i;
                        b = j;
                    }
                }
            }
        }
    }

    public static String find(int a, String s) {
        int temp = 0;
        double result = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            int t = arr[s.charAt(i)];
            result += Math.pow(a, temp) * t;
            temp++;
        }
        return String.valueOf(result);
    }

    public static boolean check(int a, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (a <= arr[s.charAt(i)]) {
                return false;
            }
        }
        return true;
    }
}