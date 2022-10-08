package 이상원;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/17478
*/
public class P002_BJ17478_재귀함수가뭔가요 {
    static int n;
    static String question = "\"재귀함수가 뭔가요?\"";
    static String answer2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static String answer3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static String answer4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    static String answer5 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String answer6 = "라고 답변하였지.";

    static void recursive(int n, String prefix) {
        System.out.println(prefix + question);
        if (n - 1 < 0) {
            System.out.println(prefix + answer5);
            System.out.println(prefix + answer6);

        } else {
            System.out.println(prefix + answer2);
            System.out.println(prefix + answer3);
            System.out.println(prefix + answer4);

            recursive(n - 1, prefix + "____");

            System.out.println(prefix + answer6);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursive(n, "");

    }
}
