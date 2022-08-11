package algorithm.study.week2.조이스틱;

public class Solution {
    public static void main(String[] args) {
        String name = "JEROEN";

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
        int mid = ((int) z - (int) a) / 2;
        int cursor = a;
        for (int i = 0; i < name.length(); i++) {
            char alpha = name.charAt(i);
            int idx = (int) alpha;
            int distUpDown = Math.abs(cursor- idx); // 현재 커서와 타겟의 차이




        }

    }
}
