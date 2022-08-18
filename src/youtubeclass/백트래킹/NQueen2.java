package youtubeclass.백트래킹;

import java.util.Scanner;

public class NQueen2 {
    static int N, cols[], ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        cols = new int[N + 1]; // 1행 부터 사용
        ans = 0;
        setQueen(1);
        System.out.println(ans);

    }

    public static void setQueen(int rowNo) { // 하나의 퀸만 가능한 모든 곳에 놓아보기

        if (rowNo > N) {
            ans++;
            return;
        } // 퀸을 다 놓았으면

        for (int i = 1; i <= N; i++) {
            cols[rowNo] = i; // 놓으려는 곳에 놓기
            // 직전까지의 상황이 유망하지 않으면 현재 퀸을 놓을 필요가 없으니 백트랙
            // 현재가 잘못됐으면 안가고 넘어가야 함
            // 백 트래킹을 안하는 것 처럼 보이지만 가지치기 하는 느낌으로 짠다
            if (!isAvailable(rowNo)) setQueen(rowNo + 1);

        }
    }

    private static boolean isAvailable(int rowNo) {
        for (int j = 1; j < rowNo; j++) {
            if (cols[j] == cols[rowNo] || rowNo - j == Math.abs(cols[rowNo] - cols[j])) return false;
        }
        return true;
    }

}
