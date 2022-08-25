package youtubeclass.위상정렬;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologyTest {

    static class Node {
        int vertex;
        Node next;

        public Node(int vertex, Node next) {
            this.vertex = vertex;
            this.next = next;
        }
    }

    static int V, E;
    static Node[] adjList;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new Node[V + 1]; // 각 정점별 인접 리스트
        inDegree = new int[V + 1]; // 정점별로 진입차수 개수

        for (int i = 0; i < E; i++) {
            // 간선 수 만큼 돌기
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from] = new Node(to, adjList[from]);
            inDegree[to]++;
        }

        ArrayList<Integer> list = topologySort();
        if (list.size() == V) {
            // 위상 정렬 완성
            for (Integer item :
                    list) {
                System.out.print(item + " ");
            }
        } else {
            // 사이클 생성됨
            System.out.println(" cycle....");
        }
    }

    static ArrayList<Integer> topologySort() {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        // 진입차수가 0인 정점 큐에 넣기
        for (int i = 1; i <= V; i++) {
            // 정점 개수 만큼 돌면서
            if (inDegree[i] == 0) queue.offer(i);
        }

        // BFS
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            list.add(cur); // 선행 작업이 없으니까 큐에서 나온것 -> 리스트에 넣어주기

            for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
                // 탐색하는 코드
                if (--inDegree[temp.vertex] == 0) queue.offer(temp.vertex); // 진입차수 줄이고 0이면 큐에 넣기
            }
        }
        return list; // 순서를 지키는 것들이 담긴다
    }
}
