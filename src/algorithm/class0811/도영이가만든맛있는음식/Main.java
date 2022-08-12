package algorithm.class0811.도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static long[][] taste;
    static long answer;
    static int[] visit;
    private static int n;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        taste = new long[n][];
        answer = Long.MAX_VALUE;
        visit = new int[n];
        for (int i = 0; i < n; i++) {
            taste[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }
        combination(0, 0, 1, 0);
        System.out.println(answer);
    }

    static void combination(int count, int start,long s ,long b) {

        //조합의 개수가 전체를 넘어가면 종료
        if (count > n) {
            return;
        }

        // 매 조합마다 신맛 - 쓴맛을 계산
        if (count > 0 && Math.abs(s-b) < answer) {
            answer = Math.abs(s - b);
        }
        for (int i = start; i < n; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                combination(count + 1, start + 1, s * taste[i][0], b + taste[i][1]);
                visit[i] = 0;
            }
        }
    }
}
