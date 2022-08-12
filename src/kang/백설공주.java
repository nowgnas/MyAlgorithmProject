package kang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백설공주 {
    public static void main(String[] args) {
        // 9 난쟁이 중에 7 난쟁이를 뽑아 그 모자의 합이 100 이 되는 ..
        Scanner sc = new Scanner(System.in);
        int[] shorts = new int[9]; // 9명의 난쟁이
        int sum = 0; // 전체 9명의 합에서 가짜 두명을 빼면 100
        for (int i = 0; i < 9; i++) {
            shorts[i] = sc.nextInt(); // 숫자가 안크니까 .. scanner
            sum += shorts[i];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                int tmp = shorts[i] + shorts[j];
                // 두명을 골라 뺏을때 100 이랑 같으면 ?! 걔네가 가짜다
                if (sum - tmp == 100) {
                    shorts[i] = 0;
                    shorts[j] = 0; // 얘네 둘을 빼줘야한다
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            System.out.println(shorts[k]);
                        }
                    }
                }
            }
        }
    } //main end
}