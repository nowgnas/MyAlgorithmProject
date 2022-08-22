package algorithm.class0822.Contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int[] inputs, visited;
    //    static boolean[] visited;
    static int length, start, maxVal, result;
    static int[][] adjTable;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 1; j <= 10; j++) {
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            length = inputs[0];
            start = inputs[1];

            adjTable = new int[101][101];
            visited = new int[101];
            result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < length / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adjTable[from][to] = 1;
            } // 입력 끝


            // 방향이 있으므로 from 과 to 를 나눠 줌
            bfs();
            System.out.println("#" + j + " " + result);
        }


    }

    static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = 1;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 1; i < adjTable[cur].length; i++) {
                if (visited[i] == 0 && adjTable[cur][i] == 1) {
                    visited[i] = visited[cur] + 1;
                    queue.offer(i);
                }
            }
            maxVal = visited[cur];
        }
        for (int i = 1; i < 101; i++) {
            if (maxVal != visited[i]) continue;
            result = result > i ? result : i;
        }
    }
}
