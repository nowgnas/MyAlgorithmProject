package 테스트준비.A형대비.낚시터자리잡기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
    static int N, ans; // 낚시터의 수
    static int[][] graph;
    static int[][] idxList = {{0, 1, 2}, {0, 2, 1}, {1, 2, 0}, {1, 0, 2}, {2, 1, 0}, {2, 0, 1}}; // 게이트의 순서

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine()); // test case
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(bf.readLine()); // 낚시터 개수
            graph = new int[3][2]; // 출입문 , 대기 인원

            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(bf.readLine());
                graph[i][0] = Integer.parseInt(st.nextToken());
                graph[i][1] = Integer.parseInt(st.nextToken());
            } // 입력완료

            ans = Integer.MAX_VALUE; // 최소값 구하라했으니까
            for (int method = 0; method < 6; method++) { // 낚시터의 출입문 수는 항상 3가지라고 했으니까 3!
                // 낚시꾼 자리 할당하는 기능
                dfs(0, method, new int[N + 1]); // depth, 게이트의 개수, 현재까지의 거리합
            }
            System.out.println("#" + tc + " " + ans);
        }

    } // main end

    private static void dfs(int depth, int method, int[] posInfo) {
        if (depth == 3) {
            ans = Math.min(ans, calcDisSum(posInfo));
            return;
        }

        int[] newPosInfo = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            newPosInfo[i] = posInfo[i];
        }
        int gate = graph[idxList[method][depth]][0];
        int fisher = graph[idxList[method][depth]][1];

        int distance = 0;

        while (fisher > 1) { // 2 명이상인 경우
            if (gate + distance <= N && newPosInfo[gate + distance] == 0) {
                newPosInfo[gate + distance] = gate;
                fisher--;
            }
            if (gate - distance > 0 && newPosInfo[gate - distance] == 0) {
                newPosInfo[gate - distance] = gate;
                fisher--;
            }
            distance++;
        }

        if (fisher == 0) {
            dfs(depth + 1, method, newPosInfo);
        } else { // 1인 경우
            distance = findMinDis(gate, newPosInfo);

            if (gate - distance > 0 && newPosInfo[gate - distance] == 0) {
                int[] copy = new int[N + 1];
                for (int i = 0; i <= N; i++) {
                    copy[i] = newPosInfo[i];
                }
                copy[gate - distance] = gate;
                dfs(depth + 1, method, copy);
            }
            if (gate + distance <= N && newPosInfo[gate + distance] == 0) {
                int[] copy = new int[N + 1];
                for (int i = 0; i <= N; i++) {
                    copy[i] = newPosInfo[i];
                }
                copy[gate + distance] = gate;
                dfs(depth + 1, method, copy);
            }
        }
    }

    static int calcDisSum(int[] posInfo) { // 배정된 낚시꾼들의 이동거리를 구하는 기능
        int sumDis = 0;
        for (int i = 1; i <= N; i++) {
            if (posInfo[i] != 0) {
                sumDis += Math.abs(posInfo[i] - i) + 1;
            }
        }
        return sumDis;

    }

    static int findMinDis(int gate, int[] posInfo) { // 게이트별 낚시꾼들을 자리에 할당하는 기능
        int left = 0;
        while (gate - left > 0 && posInfo[gate - left] != 0) {
            left++;
        }
        int right = 0;
        while (gate + right <= N && posInfo[gate + right] != 0) {
            right++;
        }

        int minDis = Math.min(left, right);
        int maxDis = Math.max(left, right);
        // 짧은 거리 로 할 수 있는 경우 아니면 긴거리로 할 수 있는 경우 중 택 1
        return (gate + minDis <= N && posInfo[gate + minDis] == 0) || (gate - minDis > 0 && posInfo[gate - minDis] == 0) ? minDis : maxDis;
    }

}