package study.week10.추월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashMap = new HashMap<>();
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String tunnelIn = br.readLine();
            hashMap.put(tunnelIn, i);
        }
        int[] result = new int[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            String tunnelOut = br.readLine();
            result[i] = hashMap.get(tunnelOut);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (result[i] > result[j]) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
