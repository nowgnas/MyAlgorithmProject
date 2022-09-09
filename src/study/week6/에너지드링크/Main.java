package study.week6.에너지드링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] drink;
    static BufferedReader br;
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        /*
         * 두 개의 음료를 고르기
         * 한쪽에 다른 음료를 붓는다
         * 붓는 과정에서 절반을 버린다
         * 남은 병은 버린다
         * 드링크가 하나 남을때 까지 반복 한다
         */
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        drink = new int[N]; // 음료를 저장할 배열 초기화
        for (int i = 0; i < N; i++) {
            drink[i] = Integer.parseInt(st.nextToken());
        } // 입력 완료
        Arrays.sort(drink); // 오름차순 정렬

        double maxDrink = drink[N - 1];
        for (int i = 0; i < N - 1; i++) {
            double half = (double) drink[i] / 2;
            maxDrink += half;
        }
        if ((int) maxDrink != maxDrink) {
            System.out.printf("%.1f", maxDrink);
        } else {
            System.out.println((int) maxDrink);
        }
    }
}
