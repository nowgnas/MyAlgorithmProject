package study.week6.여행경로;

import java.util.*;

public class Solution {

    //    static String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
    static String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
    static Queue<String> queue = new PriorityQueue<>();
    static boolean[] visited;

    public static void main(String[] args) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", 0, "ICN");

        String[] result = queue.poll().split(",");
//        return result;
        System.out.println(Arrays.toString(result));
    }

    static void dfs(String[][] tickets, String cur, int cnt, String path) {
        if (cnt == tickets.length) {
            queue.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && cur.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], cnt + 1, path + "," + tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}
