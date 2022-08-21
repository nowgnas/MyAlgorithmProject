package mystudy.permutation;

public class PermutationClass {
    static int N, totalCnt;
    static boolean[] isSelected;

    // nPn: 1부터 n까지의 수 중 n개를 모두 뽑아 순서적으로 나열
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        N = numbers.length;

        isSelected = new boolean[N + 1]; // 수가 1부터 시작해서 인덱스도 1부터 논리적으로 사용


    }

    static void perm(int cnt) { // cnt : 직전까지 뽑은 순열에 포함된 개수 , cnt+1 번째 해당하는 순열에 포함될 수 뽑기
        // 가능한 모든 수에 대해 시도
        for (int i = 1; i <= N; i++) {
            // 시도하는 수가 선택되었는지 판단
            if (isSelected[i]) continue;
            // 선택되지 않았다면 수를 사용


            // 다음 수를 뽑으러 가기

        }

    }
}
