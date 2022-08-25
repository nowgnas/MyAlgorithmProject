package algorithm.class0825.하나로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
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

            List<Node>[] queues = new ArrayList[N];
            visited = new boolean[N];


            for (int j = 0; j < N; j++) {
                queues[j] = new ArrayList<>();
                for (int k = 0; k < N; k++) {
                    double dist = weightCalculate(matrix[0][j], matrix[1][j], matrix[0][k], matrix[1][k]); // 간선 값
                    queues[j].add(new Node(k, dist));
                }
            } // 각 점에 모든 점과의 거리 저장

            Queue<Node> queue = new PriorityQueue<>((o1, o2) -> (int) (o1.weight - o2.weight));
            queue.offer(new Node(0, 0));
            int cnt = 0;
            double result = 0;
            while (!queue.isEmpty()) {
                // 신장 트리의 구성에 포함되지 않은 정점 중 최소 비용 선택
                Node miniVertex = queue.poll();

                if (visited[miniVertex.no]) continue; // 방문 되었으면 다음 값 보기

                // 신장 트리에 추가
                visited[miniVertex.no] = true; // 방문 처리
                result += miniVertex.weight; // 가중치 더해주기
                if (++cnt == N) break; // 모든 노드를 확인 했다

                // 신장 트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의 기존 최소 비용과 비교
                for (int j = 0; j < queues[miniVertex.no].size(); j++) {
                    Node tmp = queues[miniVertex.no].get(j);
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
