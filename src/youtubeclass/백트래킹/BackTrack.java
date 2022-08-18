package youtubeclass.백트래킹;

import java.util.Arrays;

public class BackTrack {
    static int[] visit; // 인덱스 방문처리를 위한 배열
    static int[] arr; // 고를 배열
    static int n, S, totalCnt; // 배열의 길이
    static boolean[] isSelected;

    public static void main(String[] args) {
        arr = new int[]{1, 2, 3, 4, 5, 12, 45, 23, 1};
        n = arr.length;
        S = 20; // 찾고자 하는 값

        visit = new int[arr.length]; // static으로 선언된 visit을 초기화
        isSelected = new boolean[arr.length];
        subSet(0, 0);
    }

    private static void subSet(int index, int sum) { // index: 부분집합에 고려할 대상 원소의 인덱스, cnt: 직전까지 고려한 원소의 수
        if (sum == S) {
            totalCnt++;
            for (int i = 0; i < n; i++) {
                System.out.print(isSelected[i] ? arr[i] : "-");
            }
            System.out.println();
            return;
        }
        // sum < S 이거나  sum > S 인 경우
        if (sum > S || index == n) return;
//        if (index == n) return; // 원소를 다 끝까지 고려해 봤지만 답이 안되는 경우도 끝내야 한다


        // 원소 선택
        isSelected[index] = true;
        subSet(index + 1, sum + arr[index]);
        // 원소 미선택
        isSelected[index] = false;
        subSet(index + 1, sum);
    }
}
