package 테스트준비.A형대비.헌터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    static int N;
    static ArrayList<Node> monsters;
    static ArrayList<Node> customers;
    static boolean[] visitedMonsters;
    static boolean[] visitedCustomers;
    static int min; // 최소 시간

    static class Node { // 고객 몬스터 번호
        int r, c, n;

        public Node(int r, int c, int n) {
            super();
            this.r = r;
            this.c = c;
            this.n = n;
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException { // 완전탐색 문제
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());// test case
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(bf.readLine()); // 한변의 길이

            int[][] graph = new int[N + 1][N + 1];
            monsters = new ArrayList<>();
            customers = new ArrayList<>();

            visitedMonsters = new boolean[5];
            visitedCustomers = new boolean[5];

            for (int i = 1; i <= N; i++) {
                String[] s = bf.readLine().split(" ");
                for (int j = 1; j <= N; j++) {
                    graph[i][j] = Integer.parseInt(s[j - 1]);
                    if (graph[i][j] > 0) { // 몬스터
                        monsters.add(new Node(i, j, graph[i][j]));
                    } else if (graph[i][j] < 0) {
                        customers.add(new Node(i, j, graph[i][j]));
                    }
                }
            }

            // dfs 호출
            for (Node n : monsters) {
                dfs(0, getDistance(n.r, n.c, 0, 0), n.r, n.c);
            }

            System.out.println("#" + tc + " " + min);
        }
    } // main end

    // DFS
    private static void dfs(int cnt, int distance, int r, int c) {
        if (distance >= min) return;
        if (cnt == monsters.size() * 2) {
            min = Math.min(min, distance);
        }

        // 몬스터 잡기
        for (Node mon : monsters) {
            if (visitedMonsters[mon.n]) continue;

            int d = getDistance(mon.r, mon.c, r, c);
            visitedMonsters[mon.n] = true;
            dfs(cnt + 1, distance + d, mon.r, mon.c);
            visitedMonsters[mon.n] = false;
        }

        // 고객 방문
        for (Node cust : customers) {
            int n = Math.abs(cust.n);
            if (visitedCustomers[n] || !visitedMonsters[n]) continue;

            int d = getDistance(cust.r, cust.c, r, c);
            visitedCustomers[n] = true;
            dfs(cnt + 1, distance + d, cust.r, cust.c);
            visitedCustomers[n] = false;
        }
    }

    // 시간을 구하는 함수 + 멘헤튼 거리 개념 ..
    private static int getDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}