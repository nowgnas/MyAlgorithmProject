package mystudy.subset;

import java.util.Arrays;
import java.util.Scanner;

public class SubsetClass {

    static int N, totalCnt;
    static int[] input;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        totalCnt = 0;
        input = new int[N];
        isSelected = new boolean[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        subset(0);

    }

    static void subset(int index) { // index : 부분집합에 고려할 대상
        if (index == N) { // 더 이상 고려할 원소가 없다면 부분 집합의 구성이 완성
            for (int i = 0; i < N; i++) {
                System.out.print(isSelected[i] ? "o" + " " : "x" + " ");
            }
            System.out.println();
            return;
        }

        // 원소 선택
        isSelected[index] = true;
        subset(index + 1);
        // 원소 미선택
        isSelected[index] = false;
        subset(index + 1);
    }
}
