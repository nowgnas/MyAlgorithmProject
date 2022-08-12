package kang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 햄버거다이어트 {
    static int N, L, ans; // 재귀함수에서 써야되니까 ..
    static int[] ti;
    static int[] ki;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // test case

        for (int tc = 1; tc <= T; tc++) {
            String[] s = bf.readLine().split(" ");
            N = Integer.parseInt(s[0]);// 재료의 수
            L = Integer.parseInt(s[1]);// 제한 칼로리
            ti = new int[N];
            ki = new int[N];

            for (int i = 0; i < N; i++) { // 재료의 수만큼 재료랑 칼로리 입력
                String s2[] = bf.readLine().split(" ");
                ti[i] = Integer.parseInt(s2[0]);
                ki[i] = Integer.parseInt(s2[1]);
            }
            ans = 0; // 최대값 초기화 ..
            Subset(0, 0, 0); //음식 점수랑 칼로리를 초기화하고 시작

            System.out.print("#" + tc + " " + ans + "\n");
        }
    }

    // 가능한 모든 부분 집합을 구해서 ..최대를 구하면 되지않을까 .. 조합
    public static void Subset(int idx, int score, int cal) { // 변하는 값인 음식 점수와 칼로리를 매개변수로
        if (idx == N) {
            if (score > ans)
                ans = score;
            return;
        }
        if (cal > L || idx >= N) { // 만약 제한 칼로리를 초과하는 경우
            return;
        }


        Subset(idx + 1, score + ti[idx], cal + ki[idx]); //  재료의 수를 늘려서 다시 ..
        Subset(idx + 1, score, cal); // 사용하지 않는 경우에는 그냥 idx ++
    }

}