package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class readme표생성기 {
    static int n, week;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("주차 입력:");
        week = Integer.parseInt(br.readLine());
        System.out.print("problem 개수: ");
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("|").append("**" + week + "회차**").append("|");
        for (int i = 0; i < n; i++) {
            System.out.print("문제종류: ");
            String opt = br.readLine();
            sb.append(opt).append("|");
            System.out.print("난이도: ");
            opt = br.readLine();
            sb.append(opt).append("|");
            System.out.print("문제이름: ");
            opt = br.readLine();
            sb.append("[").append(opt).append("]");
            System.out.print("문제링크: ");
            opt = br.readLine();
            sb.append("(").append(opt).append(")").append("|").append("|").append("\n").append("| |");
        }
        System.out.print(sb.toString());
    }
}
