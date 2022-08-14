package algorithm.study.week2.소수찾기;

import java.util.Arrays;
import java.util.HashSet;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42839

종이 조각을 붙여 소수를 몇개 만들수 있나?
조합으로 풀어야 하나??

*/
public class Solution {
    static String[] arr;
    static int n, cnt;
    static boolean[] visit;
    static String[] out;
    static HashSet<Integer> hashSet;
    static StringBuilder sb;


    public static void main(String[] args) {
        String numbers = "17";

        arr = numbers.split("");
        n = numbers.length();

        visit = new boolean[n];
        hashSet = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            comb(numbers, visit, 0, i);
        }

        for (int num :
                hashSet) {
            if (isPrime(num) && num != 0) cnt++;
        }
        System.out.println(cnt);
//        return cnt;
    }

    private static void comb(String numbers, boolean[] visit, int depth, int r) {
        if (r == 0) {
            sb = new StringBuilder();
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) sb.append(numbers.charAt(i));
            }
            hashSet.add(Integer.parseInt(String.valueOf(sb)));
            return;
        }
        if (depth == numbers.length()) return;
        else {
            visit[depth] = true;
            comb(numbers, visit, depth + 1, r - 1);

            visit[depth] = false;
            comb(numbers, visit, depth + 1, r);
        }
    }


    private static boolean isPrime(int num) {
        int mid = num / 2;
        for (int i = 2; i <= mid; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
