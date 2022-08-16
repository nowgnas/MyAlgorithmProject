package algorithm.class0816.냉장고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        int answer = 1;
        for (int i = 0; i < n; i++) {
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(array);
        }
//        list.sort((integers, t1) -> {
//            if (integers[0] < t1[0]) {
//                return -1;
//            } else if (integers[0] == t1[0]) {
//                return 0;
//            } else {
//                return 1;
//            }
//        });

//                list.sort((integers, t1) -> {
//                    return Integer.compare(integers[0], t1[0]);
//        });
        list.sort(Comparator.comparingInt(integers -> integers[1]));

        /*
        4
        -5 5
        -10 36
        10 73
        27 44
         */

        // 최저온도로 정렬시 최고온도도 오름차순으로 정렬이 되잇을거란 보장이 x

        // 정렬을 최대 온도로 정렬하고
        // 기준 잡고
        // 돌다가 최저 온도가 기준 보다 높으면 냉장고 새로만들기
        // 최저온도가 < 최고온도
        // 돌다가 최저온도가 > 기준 최고온도 이때는 냉장고를 새로 만들어야함
        // -20 3
        // -5 5
        // 10 20
        // -10 100
        // -5 3


        int[] target = list.get(0); // 처음 기준 잡기
        for (int i = 1; i < list.size(); i++) { // list 반복을 돌면서
//            if (target[0] < list.get(i)[0] && target[1] > list.get(i)[1]) { // 기준에 포함 되면 패스
//                continue;
//            } else { // 기준을 벗어나면 새로 냉장고 만들기
//                answer += 1;
//                target = list.get(i);
//            }
            if (target[1] < list.get(i)[0]) {
                answer += 1;
                target = list.get(i);
            }
        }
        System.out.println(answer);
    }
}
