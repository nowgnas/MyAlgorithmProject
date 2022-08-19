package mystudy.combination;

import java.util.Arrays;

public class Comb {
    static int[] visit; // 인덱스 방문처리를 위한 배열
    static int[] arr; // 고를 배열
    static int n; // 배열의 길이

    public static void main(String[] args) {
        arr = new int[]{1, 2, 3, 4, 5};
        n = arr.length;

        visit = new int[arr.length]; // static으로 선언된 visit을 초기화
        comb(3, 0); // 조합 시작
    }

    private static void comb(int pick, int depth) { // 고를 개수, 재귀로 들어간 깊이
        if (pick == 0) { // 더 이상 고를 수 없는 경우
            System.out.println(Arrays.toString(visit));
            return;
        }

        if (depth == n) return; // 깊이는 0부터 n-1까지이므로 n이면 탈출

        visit[depth] = 1; // 현재 보는 인덱스를 방문처리
        comb(pick - 1, depth + 1); // 고를 개수 하나 줄이면서 재귀
        visit[depth] = 0; // 현재 인덱스에서 다 골랐으면 초기 상태로 돌아가기
        comb(pick, depth + 1); // 다시 고를 개수 , 깊이 +1로 재귀
    }
}
