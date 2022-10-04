package algorithm.class1004.보물상자비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class 수지_Solution {
    static LinkedList<Character> password;
    static HashSet<Integer> set;
    static int N, K;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // test case

        for (int tc = 1; tc <= T; tc++) {
            String s[] = bf.readLine().split(" ");
            N = Integer.parseInt(s[0]); // 한 변의 숫자 개수
            K = Integer.parseInt(s[1]); // K 번째로 큰 수를 찾자 !

            String s2 = bf.readLine();
            password = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                password.add(s2.charAt(i));
            } // 입력완료

            set = new HashSet<>(); // 중복을 세지 않아야한다

            for (int i = 0; i < N / 4; i++) { // 모든 회전의 수는 N/4-1
                // 4변에 대하여
                for (int j = 0; j < 4; j++) {
                    int n = 0;
                    String tmp = "";
                    // 한변의 존재하는 16진수를 10진수 변환
                    for (int k = 0; k < N / 4; k++) {
                        tmp += String.valueOf(password.get(k));
                    }
                    n = Integer.valueOf(tmp, 16);
                    // hashset 10진수 저장
                    set.add(n);
                }
                // 회전 수행
                // 가장 뒤에 값을 앞으로 옮기면 회전과 동일
                char back = password.pollLast();
                password.addFirst(back);
            }

            ArrayList<Integer> list = new ArrayList<>(); // 내림 차순을 위해
            for (int i : set) list.add(i);

            Collections.sort(list, Collections.reverseOrder());
            System.out.println("#" + tc + " " + list.get(K - 1));

        } // test case end
    } // main end

}