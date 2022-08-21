package kang;

import java.util.Arrays;
import java.util.Scanner;

//조합 : 서로 다른  n 개에서 순서를 고려하지않고 r 개를 모두 뽑는 것
public class Comb {
    static int N, R;
    static int[] input, numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();

        input = new int[N];
        numbers = new int[R]; // 조합으로 만들어지는 배열

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        } // N 개의 입력받은 수 중 R 개의 조합 찾기

        comb(0, 0); // 시작위치와  시도한 조합의 수

    }

    private static void comb(int start, int cnt) {
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = start; i < N; i++) { // Start 하고 그다음번 자리 ..
            numbers[cnt] = input[i];

            // 다음 자리 수 뽑으러가기
            comb(cnt + 1, i + 1);
        }
    }

}