package study.week4.팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int n;
    static boolean[] visited;
    static String[] inputs, stringSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inputs = br.readLine().split("");
        n = inputs.length;
        stringSet = new String[n];
        visited = new boolean[n];

        Queue<String> queue = new PriorityQueue<>((o1, o2) -> {
            for (int i = 0; i < o1.length() - 1; i++) {
                if (o1.charAt(i) == o2.charAt(i)) {
                    return o1.charAt(i + 1) - o2.charAt(i + 1);
                }
            }
            return o1.charAt(0) - o2.charAt(0);
        });

        perm(0, queue);

        for (String item :
                queue) {
            if (isPalindrome(item)) {
                System.out.println(item);
                System.exit(0);
            }
        }
        System.out.println("I'm Sorry Hansoo");
    }

    static boolean isPalindrome(String ele) {
        // 팰린드롬 검사
        int iter = ele.length() / 2;
        int maxIdx = ele.length() - 1;
        for (int i = 0; i < iter; i++) {
            if (ele.charAt(i) == ele.charAt(maxIdx)) {
                maxIdx--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    static void perm(int cnt, Queue<String> queue) {
        if (cnt == n) {
            StringBuilder element = new StringBuilder();
            for (String str :
                    stringSet) {
                element.append(str);
            }
            queue.offer(String.valueOf(element));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            stringSet[cnt] = inputs[i];
            perm(cnt + 1, queue);
            visited[i] = false;
        }
    }
}
