package kang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 하나로인접행렬 { // 제출하니까 20개 test case 중 4개 틀리는 중 ..

    // 정점 중심
    static class Node implements Comparable<Node> {
        int vertex; // 노드
        long weight; // 가중치

        public Node(int vertex, long weight) {
            super();
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException { // 0825 오전 라이브 강의 인접리스트로 prim 구현 참고
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스 개수
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(bf.readLine()); // 정점의 수
            long[][] adjMatrix = new long[N][N];
            boolean[] visited = new boolean[N]; // 신장트리에 포함 여부

            long[][] xy = new long[N][2]; // x y 입력받기
            String[] s = bf.readLine().split(" "); // x 좌표
            for (int i = 0; i < N; i++) {
                xy[i][0] = Long.parseLong(s[i]);
            }
            String[] s2 = bf.readLine().split(" "); // y 좌표
            for (int i = 0; i < N; i++) {
                xy[i][1] = Long.parseLong(s2[i]);
            }
            double E = Double.parseDouble(bf.readLine());// 환경 부담 세율

            // 인접 행렬로 구현 !
            for (int i = 0; i < N; i++) { // 각 섬끼리의 거리 저장
                for (int j = 0; j < N; j++) {
                    adjMatrix[i][j] = (long) Math.pow(xy[i][0] - xy[j][0], 2) + (long) Math.pow(xy[i][1] - xy[j][1], 2); // 제곱이 문제 조건
                    adjMatrix[j][i] = adjMatrix[i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(adjMatrix[i]));
            }

            // 프림 알고리즘에 필요한 구조
            long[] minEdge = new long[N];
            // 프림 알고리즘  초기 상태 : 모든 점 최대값으로 설정.
            Arrays.fill(minEdge, Integer.MAX_VALUE);
            minEdge[0] = 0; //임의의 점인 0번 인덱스를 시작점으로 만들어주기

            long result = 0; // 최소 신장 트리 비용 누적
            int cnt = 0; // 신장트리에 추가된 정점 수
            while (true) {

                // step1. 신장트리의 구성에 포함되지 않은 정점 중 최소 비용 정점 선택
                long min = Integer.MAX_VALUE;
                int minNo = 0;

                for (int i = 0; i < N; i++) { //최소점 찾기
                    if (!visited[i] && min > minEdge[i]) {
                        minNo = i;
                        min = minEdge[i];
                    }
                }

                // step2. 신장트리에 추가
                visited[minNo] = true;
                result += min;
                if (++cnt == N) break;

                // step3. 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의 기존 최소 비용과 비교해서 갱신
                //          신장트트리에 새롭게 추가되는 정점의 모든 인접 정점을 들여다보며 처리
                for (int i = 0; i < N; i++) {
                    if (!visited[i] && minEdge[i] > adjMatrix[minNo][i]) {
                        minEdge[i] = adjMatrix[minNo][i];
                    }
                }
            }
            // 소수점 첫째자리에서 반올림
            System.out.println("#" + tc + " " + Math.round(result * E));

        }// test case end
    } // main end

}