package youtubeclass.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());
        int[][] adhMatrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < V; j++) {
                adhMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료

        int start = 0; // 시작은 0
        int end = V - 1; // 도착 정점
        // 다익스트라 알고리즘에 필요한 자료 구조
        int[] D = new int[V]; // 정정 개수 만큼 출발지에서 자신으로 오는데 소요되는 최소 비용
        boolean[] visited = new boolean[V]; // 처리한 정점 여부 방문 처리

        Arrays.fill(D, Integer.MAX_VALUE);
        // 출발정점 처리
        D[start] = 0; // 시작 지점 0
        int min, minVertex;

        for (int i = 0; i < V; i++) {
            // 정점 개수 만큼

            // step 1. 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
            // 방문해야 하는 정점 중 출발지에서 가장 가까운 정점 찾기
            min = Integer.MAX_VALUE;
            minVertex = -1;
            for (int j = 0; j < V; j++) {
                if (!visited[j] && min > D[j]) {
                    min = D[j]; // 최소값 갱신
                    minVertex = j;
                }
            }
            // step 2. 방문 처리
            visited[minVertex] = true;
            if (minVertex == end) break; // S에서 end로의 최단이면 탈출 해야 한다 || 다 구해야 하면 탈출하면 안된다

            // step 3. 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 기존 최적해보다 유리하면 갱신
            for (int j = 0; j < V; j++) {
                if (!visited[j] && adhMatrix[minVertex][j] > 0 && D[j] > D[minVertex] + adhMatrix[minVertex][j]) {
                    D[j] = D[minVertex] + adhMatrix[minVertex][j];
                }
            }
        }
        System.out.println(Arrays.toString(D));
        System.out.println(D[end]);
    }
}
