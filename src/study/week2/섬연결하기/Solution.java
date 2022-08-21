package study.week2.섬연결하기;

import java.util.Arrays;

public class Solution {
    static int n, cnt, cost;
    static int[] cycle;

    public static void main(String[] args) {
        n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        cnt = 0;
        // 사이클 테이블 선언
        cycle = new int[n];
        for (int i = 0; i < n; i++) {
            cycle[i] = i;
        }

        // 비용 순으로 정렬
        Arrays.sort(costs, ((o1, o2) -> o1[2] - o2[2]));

        for (int i = 0; i < costs.length; i++) {
            int[] item = costs[i];

            // 사이클 테이블 갱신
            int start = item[0]; // source
            int end = item[1]; // dest
            cost = item[2];

            // 만약에 부모가 다르면 사이클이 안생기고 cost 를 더해주면서 연결해주면뎀
            if (find(start) != find(end)) {
                cnt += cost;
                union(start, end);
            }
        }
        System.out.println(cnt);
//        return cnt;
    }

    private static int find(int node) {
        if (cycle[node] == node) return node;
        return cycle[node] = find(cycle[node]);
    }

    private static void union(int start, int end) {
        int startParent = find(start);
        int endParent = find(end);

        if (startParent > endParent) cycle[startParent] = endParent;
        else cycle[endParent] = startParent;
    }
}

