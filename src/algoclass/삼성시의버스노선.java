package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 삼성시의버스노선 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());


        for (int i = 1; i <= tc; i++) {
            int[] bus = new int[5001]; // 버스 정류장 초기화
            int N = Integer.parseInt(br.readLine()); // 테스트 케이스
            int[][] line = new int[N][]; // 저장할 배열 초기화
            for (int j = 0; j < N; j++) { // 배열에 저장하기 N개의 줄에 A, B
                line[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            for (int j = 0; j < N; j++) {
                for (int k = line[j][0]; k <= line[j][1]; k++) {
                    bus[k] += 1;
                }
            }

            sb.append("#").append(i);
            int P = Integer.parseInt(br.readLine()); // P 입력
            for (int j = 0; j < P; j++) { // C 입력 받기
                int p = Integer.parseInt(br.readLine());
                sb.append(" ").append(bus[p]);
            } // 입력 완료
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
