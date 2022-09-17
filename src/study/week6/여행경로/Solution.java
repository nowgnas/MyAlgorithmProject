package study.week6.여행경로;

import java.util.*;

public class Solution {

    //    static String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
    static String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
    static Queue<String> queue = new PriorityQueue<>();
    static boolean[] visited;

    public static void main(String[] args) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", 0, "ICN"); // ICN에서 출발 , ICN을 경로에 추가 해 줌

        String[] result = queue.poll().split(",");
//        return result;
        System.out.println(Arrays.toString(result));
    }

    static void dfs(String[][] tickets, String cur, int cnt, String path) {
        if (cnt == tickets.length) { // cnt가 길이와 같으면 모든 배열을 확인한 것
            queue.add(path); // 여행 경로에 추가
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && cur.equals(tickets[i][0])) { // 방문한 적이 없고 현재 도시가 다음 여행 경로 도착지인 경우
                visited[i] = true; // 방문 처리
                dfs(tickets, tickets[i][1], cnt + 1, path + "," + tickets[i][1]); // 다음 경로 확인
                visited[i] = false; // 모든 배열 확인 후 되돌리기
            }
        }
    }
}
