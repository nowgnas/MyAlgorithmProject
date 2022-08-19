package 테스트준비._13일의금요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 2019; i <= num; i++) {
            if (i % 400 == 0) {
                // 윤년
            } else if (i % 100 != 0 && i % 4 == 0) {
                // 윤년

            } else {
                // 윤년이 아님
            }
        }

    }

    static void calDay(int num) {
        // 일 월 화 수 목 금 토
        // 0 1 2 3 4 5 6 7

        // 2019 1월 1일이 화요일
        int month = 1;
        int day = 1;

        switch (month){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
        }




    }
}
