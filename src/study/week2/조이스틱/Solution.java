package study.week2.조이스틱;

public class Solution {
    static int answer, idx, next;
    static char alpha;

    public static void main(String[] args) {
        String name = "JAN";

        /*
        https://school.programmers.co.kr/learn/courses/30/lessons/42860
         * 조이스틱 알파벳으로 이름을 완성
         * 맨 처음은 A로만 이뤄짐
         * 위 - 다음 알파벳
         * 아래 - 이전 알파벳(A에서 아래쪽으로 이동하면 z로 )
         * 왼쪽 - 커서를 왼쪽으로 이동
         * 오른쪽 - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
         *
         * */
        char a = 'A';
        char z = 'Z';
        answer = 0;
        next = name.length() - 1; // 다음 알파벳을 보는 것

        for (int i = 0; i < name.length(); i++) {
            alpha = name.charAt(i);
            answer += Math.min(alpha - a, z - alpha + 1);
            idx = i + 1;
            while (idx < name.length() && name.charAt(idx) == 'A') {
                idx++;
            }
            next = Math.min(next, i + (name.length() - idx) + Math.min(i, name.length() - idx));
        }
        System.out.println(answer + next);
//        return answer + next;
    }
}
