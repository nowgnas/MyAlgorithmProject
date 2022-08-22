package mystudy.fortest;

import java.util.Arrays;

public class PermTest {
    static int n;
    static int[] numbers, arr;
    static boolean[] visited;


    public static void main(String[] args) {
        arr = new int[]{1, 2, 3, 4, 5};
        n = arr.length;

        visited = new boolean[n];
        numbers = new int[n];

        perm(0);


    }

    static void perm(int cnt) {
        if (cnt == n) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            numbers[cnt] = arr[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}
