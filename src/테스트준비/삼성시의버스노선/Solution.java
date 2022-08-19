package 테스트준비.삼성시의버스노선;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            int N = Integer.parseInt(br.readLine());
            int [][] line = new int[N][];
            for (int j = 0; j < N; j++) {
                line[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

        }
    }
}
