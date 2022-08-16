package youtubeclass.class0811.nextpermutaion;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);
        do {
            System.out.println(Arrays.toString(input)); // 순열 완성
        } while (np(input));
    }

    public static boolean np(int[] numbers) {
        // numbers 배열의 상태를 근거로 다음 순열을 생성
        // 다음 순열 존재하면 true, 아니면 false

        int N = numbers.length;
        // 꼭대기 찾기
        int i = N - 1;
        while (i > 0 && numbers[i - 1] >= numbers[i]) --i; // 지금이 처음원소가 아니고 이전이 크거나 같으면

        if (i == 0) return false; // 더이상 다음 순열을 만들수 없다 이미 가장 큰 순열의 상태

        // 꼭대기 바로 앞자리 (i-1)의 값을 크게 만들 교환 값 뒤쪽에서 찾기
        int j = N - 1; // 맨 뒤 부터 탐색
        while (numbers[i - 1] >= numbers[j]) --j; // 큰 수를 찾을때 까지 돈다

        // i-1의 위치값과 j 위치 값을 교환한다 swap()
        swap(numbers, i - 1, j); // swap한다

        // i 위치부터 맨 뒤까지의 수열을 가장 작은 형태의 오름차순으로 변경
        int k = N - 1;
        while (i < k) { // k는 맨뒤 i는 앞
            swap(numbers, i++, k--);
        }
        return true;
    }

    public static void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
