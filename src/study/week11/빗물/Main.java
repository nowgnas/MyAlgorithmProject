package study.week11.빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int h, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();
        int volume = 0;

        for (int i = 0; i < arr.length; i++) { // 주어진 배열만큼 돌기
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) { // 현재 높이와 stack의 head에 있는 값 비교
                // 현재 값이 head보다 크면
                int top = stack.pop();
                if (stack.isEmpty()) break;

                int dist = i - stack.get(0) - 1;
                int water = Math.min(arr[i], arr[stack.peek()]) - arr[top];
                volume += dist * water;
            }
            stack.push(i); // stack에 현재 높이 저장
        }
        System.out.println(volume);
    }
}
