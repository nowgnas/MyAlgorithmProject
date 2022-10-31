package study.week11.빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static int h, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int volume = 0;
        if (arr.length == 0) {
            System.out.println(0);
            System.exit(0);
        } else {
            int left = 0; // 왼쪽 시작 0
            int right = arr.length - 1; // 오른쪽 시작 배열 길이

            int leftMax = arr[left]; // 왼쪽 시작 값
            int rightMax = arr[right]; // 오른쪽 시작 값

            while (left < right) {
                leftMax = Math.max(arr[left], leftMax); // 왼쪽에서 오는 높은 벽
                rightMax = Math.max(arr[right], rightMax); // 오른쪽에서 오는 높은 벽

                if (leftMax <= rightMax) { // 더 높은 쪽을 항해 투 포인터 이동
                    volume += leftMax - arr[left]; // 왼쪽에서 높은 벽 - 왼쪽 포인터
                    left += 1;
                } else {
                    volume += rightMax - arr[right]; // 오른쪽 높은 벽 - 오른족 포인터
                    right -= 1;
                }
            }
        }
        System.out.println(volume);
    }
}
