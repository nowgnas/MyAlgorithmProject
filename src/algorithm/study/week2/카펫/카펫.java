package algorithm.study.week2.카펫;

import java.util.Arrays;

public class 카펫 {
    public static void main(String[] args) {
        int brown = 8;
        int yellow = 1;
        if (yellow ==1) {
//            return new int[]{3, 3};
            System.out.println("1일때");
        }

        int ractangle = brown + yellow; // 전체 사각형 넓이
        int[] answer = new int[2];

        int mid = yellow / 2;
        for (int i = mid; i > 0; i--) {
            if (yellow % i == 0) {
                if (ractangle == (i + 2) * (yellow / i + 2)) {
                    int x = i + 2;
                    int y = yellow / i + 2;
                    answer[0] = x < y ? y : x;
                    answer[1] = x < y ? x : y;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(answer));
//        return answer;
    }
}
