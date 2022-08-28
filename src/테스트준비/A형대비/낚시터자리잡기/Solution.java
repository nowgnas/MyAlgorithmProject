package 테스트준비.A형대비.낚시터자리잡기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static boolean[] visited;
    static int[] gateSet, gate;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            // 지도를 만들어야 하나??
            int N = Integer.parseInt(br.readLine()); // 낙시터 자리 개수 N

            map = new int[2][61];
            gate = new int[3];
            visited = new boolean[3]; // 조합을 위한 방문 처리
            gate = new int[3]; // gate 숫자 저장 용 -> 조합에 사용
            gateSet = new int[3]; // 생성될 조합 초기화

            for (int j = 0; j < 3; j++) {
                int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int enter = inputs[0]; // 출입구 위치
                int waiting = inputs[1]; // 대기 중인 낚시꾼
                map[1][enter] = waiting; // 출입구에 몇명 있는지
                gate[j] = enter; // gate 숫자 저장
            }
            for (int j = 0; j < 2; j++) {
                System.out.println(Arrays.toString(map[j]));
            }
            System.out.println(Arrays.toString(gate));

            perm(0, 3);


        }

    }

    static void perm(int cnt, int pick) {
        if (cnt == pick) {
            // 시작점 순열로 생성
            for (int i = 0; i < gateSet.length; i++) {
                // 가장 가까운 곳 부터 간다
                for (int j = 0; j < map[1][gateSet[i]]; j++) {
                    // 낚시꾼 수 만큼

                }



            }
            System.out.println();

            return;
        }

        for (int i = 0; i < 3; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            gateSet[cnt] = gate[i];
            perm(cnt + 1, pick);
            visited[i] = false;
        }
    }
}
