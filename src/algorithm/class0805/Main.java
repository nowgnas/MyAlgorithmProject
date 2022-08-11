package algorithm.class0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/*
P015_BJ12891_DNA비밀번호
P016_BJ2023_신기한소수
P017_BJ2493_탑
https://www.acmicpc.net/problem/12891
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] alpha = br.readLine().split("");
        int[] acgt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] acgtArray = {"A", "C", "G", "T"};
        // 입력 끝

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < alpha.length; i++) {
            if (map.get(alpha[i]) == null) map.put(alpha[i], 1);
            else {
                map.put(alpha[i], map.get(alpha[i]) + 1);
            }
        }
        int answer = 0;
        for (int i = 0; i < acgt.length; i++) {
            if (map.get(acgtArray[i]) != null && acgt[i] > map.get(acgtArray[i])) {
                // 성립 안됨
                System.out.println(answer);
                break;
            }
        }
        // 개수 어떻게 세지..

    }
}
