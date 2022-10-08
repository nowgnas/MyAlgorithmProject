package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class P051_SWEA3289_서로소집합 {
    static int tc, n, m;
    static int[] inputs, parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        tc = Integer.parseInt(br.readLine());


        for (int i = 1; i <= tc; i++) {
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = inputs[0];
            m = inputs[1];
            parent = IntStream.range(0, n + 1).toArray();


            sb.append("#").append(i).append(" ");
            for (int j = 0; j < m; j++) {
                inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                if (inputs[0] == 0) {
                    // union
                    // 부모가 크게 상관이 없다
                    union(inputs[1], inputs[2]);

                } else if (inputs[0] == 1) {
                    // check
                    boolean check = find(inputs[1]) == find(inputs[2]);
                    if (check) sb.append(1);
                    else sb.append(0);
                }
            }
            sb.append("\n");
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
        if (aParent > bParent) parent[aParent] = bParent;
        else parent[bParent] = aParent;
    }
}
