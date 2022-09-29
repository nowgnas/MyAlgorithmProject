package ssafy보충.알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpFQaAQMDFAUq
/*
* 완전 탐색으로 푼다
* 완전 탐색에서 고민할 것 -> 시간에 대해 고민해야 한다
* 얼마나 걸리는지 시간을 확인해 봐야 함
* 1일 이용권 1달, 3달, 1년
*
* 기간이 짧은 것이 무조건 싸다는 것은 없다
* 1일, 1달, 3달 이용권을 사용한 것의 최소 비용과 년간 비용을 마지막에 비교한다
*
* 1일권
* 1일권             1달권             3달권
* 1일권 1달권 3달권   1일, 1달 3달       1일, 1달, 3달
*
* 위 작업을 12달 동안 해야한다
* 매 선택지마다 3개의 선택을 한다
* 재귀로 구현 가능하다
* */
public class 수영장 {
    static int t;
    static BufferedReader br;
    static StringTokenizer st;
    static Queue<Price> queue;

    static class Price {
        int month, price;

        public Price(int month, int price) {
            this.month = month;
            this.price = price;
        }
    }

    static int[] months = {1, 30, 90, 365};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            queue = new PriorityQueue<>((o1, o2) -> o1.price - o2.price);
            int[] price = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                queue.offer(new Price(months[j], Integer.parseInt(st.nextToken())));
            }

            int[] month = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        }

    }
}
