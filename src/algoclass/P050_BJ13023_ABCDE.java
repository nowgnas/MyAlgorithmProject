package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P050_BJ13023_ABCDE {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m, a, b;
    private static List<Integer>[] graph;
    private static int[] visit;

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        visit = new int[n];
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int[] array1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            a = array1[0];
            b = array1[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, 0);
        }
        System.out.println(0);

    }

    private static void dfs(int node, int count) {
        visit[node] = 1;
        if (count == 4) {
            System.out.println(1);
            System.exit(0);
        }

        for (Integer nextNode : graph[node]) {
            if (visit[nextNode] == 0) {
                dfs(nextNode, count + 1);
            }
        }
        visit[node] = 0;

    }
}
