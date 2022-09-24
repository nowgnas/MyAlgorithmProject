package study.week8.국회의원선거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;

    static BufferedReader br;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n - 1; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;
        int tmp = 0;
        while (true) {
            if (!queue.isEmpty())
                tmp = queue.poll();
            if (target > tmp) {
                break;
            }
            target++;
            cnt++;
            queue.offer(--tmp);
        }
        System.out.println(cnt);
    }
}
