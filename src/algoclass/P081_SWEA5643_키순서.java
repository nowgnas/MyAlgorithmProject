package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P081_SWEA5643_키순서 { public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(bf.readLine());
    for (int tc = 1; tc <= T; tc++) {
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[][] distance = new int[N + 1][M + 1];

        for (int d = 0; d < M; d++) {
            String s[] = bf.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            distance[x][y] = 1; // 연결 되어 있는 경우 ..
        } // 입력 완료 ac

        int answer = 0; // 순위를 매길 수 있는 노드가 몇 개인지

        // 플루이드-워셜 알고리즘 실행
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (distance[j][i] == 1 && distance[i][k] == 1)  // j > i 이고 i > z 이니까
                        distance[j][k] = 1; // j 는 당연히 k 를 이긴다 !

                }
            }
        }
//            System.out.println(Arrays.toString(distance[1]));
        for (int i = 1; i <= N; i++) { // 선수는 1번부터 있으니까
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (distance[i][j] == 1 || distance[j][i] == 1)
                    cnt++;
            }
            if (cnt == N - 1) { // n 번 선수의 순위를 매기기 위해 n-1 개 정보를 알아야한다
                answer++;
            }
        }

        sb.append("#" + tc + " " + answer + "\n");
    }
    System.out.println(sb);
}

}