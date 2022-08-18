package youtubeclass.dfsbfs;

import java.util.Scanner;

public class AdjListTest {
    static class Node {
        int to;
        Node next;

        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }

        static int N;
        static boolean[] visited;
        static Node[] adjList;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            int E = sc.nextInt();

            adjList = new Node[N];

            for (int i = 0; i < E; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                adjList[from] = new Node(to, adjList[from]);
                adjList[to] = new Node(from, adjList[to]);

            }
            dfs(0);

        }

        private static void dfs(int cur) {
            visited[cur] = true;

            System.out.print((char) (cur + 'A'));

            for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
                if (!visited[temp.to]) {
                    dfs(temp.to);
                }
            }
        }
    }

}
