package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class P053_SWEA7465_창용마을무리의개수 {
    static int n, m, tc;
    static int[] inputs, visited, parent;
    static int[][] adjMatrix;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            n = inputs[0]; // 사는 사람 수
            m = inputs[1]; // 알고 있는 사람의 관계 수

            adjMatrix = new int[n + 1][n + 1]; // 인접 행렬
            visited = new int[n + 1]; // 방문 여부
            parent = new int[n + 1]; // 부모 노드 저장
            for (int j = 1; j <= n; j++) {
                parent[j] = j;
            }

            for (int j = 0; j < m; j++) {
                inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int a = inputs[0];
                int b = inputs[1];

                // union find로 부모 작은 거 개수 세야 함
                if (find(a) != find(b)) union(a, b);
            }
            HashSet<Integer> hashSet = new HashSet<>();

            for (int j = 1; j <= n; j++) {
                parent[j] = find(j);
                hashSet.add(parent[j]);
            }
            sb.append("#").append(i).append(" ").append(hashSet.size()).append("\n");
        }
        System.out.print(sb);

    }

    static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent < bParent) parent[bParent] = aParent;
        else parent[aParent] = bParent;
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}
