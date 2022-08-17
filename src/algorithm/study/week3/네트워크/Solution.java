package algorithm.study.week3.네트워크;


public class Solution {
    static int n, cnt;
    static int[] visit;

    public static void main(String[] args) {
        n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        cnt = 0;
        visit = new int[n]; // 방문 여부 저장


    }

    private static void dfs(int dot, int[][] computers) {
        if (visit[dot] == 1) return;
        visit[dot] = 1;
        for (int i = 0; i < n; i++) {
            // each item
            if (dot == i) continue;
            if (computers[dot][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}
