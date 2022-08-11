package algorithm.class0804.암호생성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int tn = Integer.parseInt(br.readLine()); // test case num
            int[] number = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Deque<Integer> deque = new ArrayDeque<>();
            for (int item :
                    number) {
                deque.add(item);
            }

            int cnt = 1;
            while (true) {
                int minus = cnt % 5 == 0 ? 5 : cnt % 5;
                int getNum = deque.removeFirst();
                getNum -= minus;
                if (getNum <= 0) {
                    deque.add(0);
                    break;
                }
                deque.add(getNum);
                cnt++;
            }
            System.out.print("#" + tn + " ");
            for (int j = 0; j < 7; j++) {
                System.out.print(deque.removeFirst() + " ");
            }
            System.out.print(deque.removeFirst() + "\n");
        }
    }
}
