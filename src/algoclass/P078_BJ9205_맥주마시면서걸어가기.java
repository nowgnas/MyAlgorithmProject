package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P078_BJ9205_맥주마시면서걸어가기 {
    static int t, n;

    static class Node {
        int y, x;


        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static List<List<Integer>> result;
    static List<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            list = new ArrayList<>();
            result = new ArrayList<>();
            for (int j = 0; j < n + 2; j++) {
                result.add(new ArrayList<>());
            }

            for (int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }


            for (int j = 0; j < n + 2; j++) {
                for (int k = j + 1; k < n + 2; k++) {
                    if (dist(list.get(j), list.get(k))) {
                        result.get(j).add(k);
                        result.get(k).add(j);
                    }
                }
            }
            sb.append(bfs() ? "happy" : "sad").append("\n");
        }
        System.out.print(sb);
    }

    static boolean bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        boolean[] visited = new boolean[n + 2];
        visited[0] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == n + 1) {
                return true;
            }
            for (int next :
                    result.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return false;
    }

    static boolean dist(Node n1, Node n2) {
        return Math.abs(n1.y - n2.y) + Math.abs(n1.x - n2.x) <= 1000;
    }
}