package youtubeclass.class0816.동전자판기;

import java.util.Scanner;

public class MAin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int targetMoney = sc.nextInt();
        int[] units = {500, 100, 50, 10, 5, 1};
        int[] counts = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};

        int totalMoney = 0;
        for (int i = 0, size = units.length; i < size; i++) {
            totalMoney += units[i] * counts[i];
        } // 보유하고 있는 모든 동전들로 만들 수 있는 금액 계산

        int remainMoney = totalMoney - targetMoney; // 갖고 있는 돈에서 음료수 값을 지불하고 남은 나머지 금액
        // 음료수 값을 지불하는 데 동전을 최대로 사용하려면, 지불하고 남은 금액의 동전수를 최소로 하면 됨

        int sum = 0, maxCnt, availCnt;
        for (int i = 0, size = units.length; i < size; i++) { // 가장 큰 화폐 단위부터 많이 사용하도록 처리
            maxCnt = remainMoney / units[i]; // 남은 금액을 큰 화폐로 나눈다
            availCnt = maxCnt <= counts[i] ? maxCnt : counts[i];

            counts[i] -= availCnt; // 사용하고 남은 개수
            remainMoney -= availCnt * units[i];

            sum += counts[i]; // 사용되고 남은 동전이 지불하기 위해 사용될 동전 개수
        }
        System.out.println(sum);
    }
}
