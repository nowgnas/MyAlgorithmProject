package ssafy보충.알고리즘.숫자만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수지_숫자만들기 {
    static int max, min, N;
    static int[] oper, nums;
    static int[] operArr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine()); // test case
        for (int tc = 1; tc <= T; tc++) {
            max = 0; // 최대가 되는 수식
            min = 0; // 최소가 되는 수식

            N = Integer.parseInt(bf.readLine()); // 숫자의 개수

            //0: +, 1: -, 2: *, 3 : /
            oper = new int[N - 1];
            String s[] = bf.readLine().split(" ");
            for (int i = 0; i < N - 1; i++) {
                oper[i] = Integer.parseInt(s[i]);
            } // 연산자 입력

            nums = new int[N];
            String s2[] = bf.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(s2[i]);
            } // 숫자 입력

            operArr = new int[4];
            perm(0);

            System.out.println("#" + tc + " " + (max - min));
        } // test case end
    } // main end

    private static void perm(int cnt) { // 연산자 순열 !
        if (cnt == N - 1) { // 주어진 연산자 개수로 모든 순열을 만든 경우
            // 최대랑 최소를 만들어주자 !
            int tmp = 0;
            for (int i = 0; i < N - 1; i++) { // 이제 숫자를 꺼내면서 ..
                tmp += nums[i]; // 숫자하나를 넣고 시작한다 ..

                switch (oper[i]) { // 연산자에 맞춰 연산
                    case 0: // 더하기
                        tmp += nums[i + 1];
                        break;

                    case 1: // 빼기
                        tmp -= nums[i + 1];
                        break;

                    case 2: //  곱하기
                        tmp *= nums[i + 1];
                        break;
                    case 3: //  나누기
                        tmp /= nums[i + 1];
                        break;
                }
            }
            if (tmp > max) max = tmp; // 최대를 구하기
            else if (tmp < min) min = tmp; // 최소를 구하기
            return;
        }


        for (int i = 0; i < N - 1; i++) { // 모든 경우에 대해서 시도
            if (oper[i] == 0) continue;
            oper[i] -= 1;
            operArr[cnt] = i;
            perm(cnt + 1); // 다음 자리수로 이동
            oper[i] += 1;
        }
    }


}