package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P035_BJ2839_설탕배달 {private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n + 1];
        array[3] = 1;
        array[5] = 1;

        for (int i = 6; i < n + 1; i++) {

            if (array[i - 3] != 0) {
                array[i] = array[i - 3] + 1;
            }
            if (array[i - 5] != 0) {
                array[i] = array[i - 5] + 1;
            }
        }
        if (array[n] == 0) {
            System.out.println(-1);

        } else {
            System.out.println(array[n]);
        }
    }
}
