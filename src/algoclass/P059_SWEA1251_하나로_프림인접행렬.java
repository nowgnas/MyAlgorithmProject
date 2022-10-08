package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class P059_SWEA1251_하나로_프림인접행렬 {
    static int tc, N;
    static double E;

    static double[][] matrix;
    static boolean[] visited;

    static class Node {
        int no;
        double weight;

        public Node(int no, double weight) {
            this.no = no;
            this.weight = weight;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());
        matrix = new double[2][N];

        for (int i = 1; i <= tc; i++) {
            N = Integer.parseInt(br.readLine()); // 노드 개수
            for (int j = 0; j < 2; j++) { // 각 노드 입력 받기
                matrix[j] = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            }
            E = Double.parseDouble(br.readLine()); // 가중치
            // 입력 끝

            visited = new boolean[N];
            Node[][] adjList = new Node[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    double dist = weightCalculate(matrix[0][j], matrix[1][j], matrix[0][k], matrix[1][k]); // 간선 값
                    adjList[j][k] = new Node(k, dist);
                }
            } // 행렬 완성

            for (int j = 0; j < N; j++) {
                System.out.println(Arrays.toString(adjList[j]));
            }

            // 큐 생성
            Queue<Node> queue = new PriorityQueue<>((o1, o2) -> (int) (o1.weight - o2.weight));
            queue.offer(new Node(0, 0));
            int cnt = 0;
            double result = 0;
            while (!queue.isEmpty()) {
                Node minVertex = queue.poll(); // 큐 위 값 빼기

                if (visited[minVertex.no]) continue;

                visited[minVertex.no] = true;
                result += minVertex.weight;
                if (++cnt == N) break;

                for (int j = 0; j < N; j++) {
                    Node tmp = adjList[minVertex.no][j];
                    if (!visited[tmp.no]) {
                        queue.add(tmp);
                    }
                }
            }
            System.out.printf("#%d %.0f\n", i, result * E);
        }

    }

    static double weightCalculate(double x, double y, double x2, double y2) {
        double X = Math.abs(x - x2);
        double Y = Math.abs(y - y2);
        return X * X + Y * Y;
    }
}
