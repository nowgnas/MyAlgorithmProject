package algorithm.class0823.최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static int tc, V, E;
    static long costs;
    static int[] parent, inputs;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            V = inputs[0];
            E = inputs[1];
            parent = new int[V + 1];
            costs = 0;
            int[][] item = new int[E][];

            for (int j = 1; j <= V; j++) {
                parent[j] = j;
            }

            for (int j = 0; j < E; j++) {
                // 간선 정보 입력 받기
                inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int A = inputs[0];
                int B = inputs[1];
                int cost = inputs[2];
                item[j] = new int[]{cost, A, B};
            }

            Arrays.sort(item, ((o1, o2) -> o1[0] - o2[0]));
            for (int[] val :
                    item) {
                int cost = val[0];
                int start = val[1];
                int end = val[2];

                if (find(start) != find(end)) {
                    costs += cost;
                    union(start, end);
                }
            }
            sb.append("#").append(i).append(" ").append(costs).append("\n");
        }
        System.out.print(sb);
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent < bParent) parent[bParent] = aParent;
        else parent[aParent] = bParent;

    }
}
