package algorithm.study.week3.타겟넘버;

public class Solution {

    static int answer;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        dfs(numbers, 0, 0, target); // dfs 시작 주어진 배열, 탐색 깊이, 합, 목표 값
        System.out.println(answer);
    }

    static void dfs(int[] arr, int cnt, int sum, int target) {
        if (cnt == arr.length) { // 깊이가 배열의 길이와 같아지면
            if (target == sum) { // 목표 값과 합이 같은지 확인
                answer++; // answer 추가
            }
            return; // 리턴
        }

        dfs(arr, cnt + 1, sum + arr[cnt], target); // cnt 깊이 +1 합에 현재 확인 중인 cnt 자리 값 더하기
        dfs(arr, cnt + 1, sum - arr[cnt], target); // 빼는 경우 확인
    }
}
