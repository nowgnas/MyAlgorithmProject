package mystudy.순조부외우기;

import java.util.Arrays;
import java.util.Scanner;

public class 순조부테스트 {
    static int N, R, input[], numbers[];
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();

        input = new int[N];
        isSelected = new boolean[N];


        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        numbers = new int[N];
        System.out.println("순열===========");
        permutaion(0);
        numbers = new int[R];
        System.out.println("조합==========");
        combination(0, 0);
        System.out.println("부분집합========");
        subset(0);
    }

    static void subset(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(isSelected[i] ? input[i] + " " : "x" + " ");
            }
            System.out.println();
            return;
        }

        isSelected[cnt] = true;
        subset(cnt + 1);
        isSelected[cnt] = false;
        subset(cnt + 1);
    }

    static void combination(int cnt, int start) {
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = start; i < N; i++) {
            numbers[cnt] = input[i];
            combination(cnt + 1, i + 1);
        }
    }

    private static void permutaion(int cnt) {
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            numbers[cnt] = input[i];
            permutaion(cnt + 1);
            isSelected[i] = false;
        }
    }
}
