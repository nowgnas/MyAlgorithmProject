package algorithm.class0804.괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            // deque에 괄호 넣기
            String arrs = br.readLine();
            Stack<String> stack = new Stack<>();

            for (int j = 0; j < arrs.length(); j++) {
                if (stack.isEmpty()) { // 스택이 비면 추가
                    stack.push(String.valueOf(arrs.charAt(j)));
                } else {
                    // stack에 하나 있는 경우
                    switch (stack.peek()) {
                        case "{":
                            if (arrs.charAt(j) == '}') {
                                stack.pop();
                                break;
                            } else {
                                stack.push(String.valueOf(arrs.charAt(j)));
                            }
                            break;
                        case "[":
                            if (arrs.charAt(j) == ']') {
                                stack.pop();
                                break;
                            } else {
                                stack.push(String.valueOf(arrs.charAt(j)));
                            }
                            break;
                        case "(":
                            if (arrs.charAt(j) == ')') {
                                stack.pop();
                                break;
                            } else {
                                stack.push(String.valueOf(arrs.charAt(j)));
                            }
                            break;
                        case "<":
                            if (arrs.charAt(j) == '>') {
                                stack.pop();
                                break;
                            } else {
                                stack.push(String.valueOf(arrs.charAt(j)));
                            }
                            break;
                    }
                }
            }
            sb.append("#").append((i + 1)).append(" ").append(stack.size() == 0 ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }
}
