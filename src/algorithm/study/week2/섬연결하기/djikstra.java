package algorithm.study.week2.섬연결하기;

public class djikstra {
    static int[][] graph;
    static boolean[] visited;
    static int[] distance;
    static int n, inf;

    public static void main(String[] args) {
        n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        inf = Integer.MAX_VALUE;
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        distance = new int[n + 1];

        // 모든 간선 정보를 입력 받기
        for (int i = 0; i < costs.length; i++) {
            int[] tmp = costs[i];
            graph[tmp[0]] = new int[]{tmp[1], tmp[2]};
        }
        dijkstra(0);
        for (int i = 1; i < n + 1; i++) {
            if (distance[i] == inf) {
                System.out.println("inf");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    private static int smallestNode() {
        int minVal = Integer.MAX_VALUE;

        int index = 0;
        for (int i = 1; i < n + 1; i++) {
            if (distance[i] < minVal && !visited[i]) {
                minVal = distance[i];
                index = i;
            }
        }
        return index;
    }

    private static void dijkstra(int start) {
        distance[start] = 0;
        visited[start] = true;
        for (int q = 0; q < graph[start].length; q++) {
            distance[graph[q][0]] = graph[q][1];
        }
        for (int i = 0; i < n - 1; i++) {
            int now = smallestNode();
            visited[now] = true;
            for (int j = 0; j < graph[now].length; j++) {
                graph[now][j] = distance[now] + graph[j][1];
                if (graph[now][j] < distance[graph[now][0]]) {
                    distance[graph[now][0]] = graph[now][j];
                }
            }
        }
    }
}
