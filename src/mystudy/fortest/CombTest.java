package mystudy.fortest;

import java.util.Arrays;

public class CombTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int pick = 3;

        int[] newArr = new int[pick];
        int[] visited = new int[arr.length];

        comb(0, 0, pick, visited, arr);


    }

    static void comb(int start, int cnt, int pick, int[] visited, int[] arr) {
        if (cnt == pick) {
            System.out.println(Arrays.toString(visited));
            return;
        }
        for (int i = start; i < visited.length; i++) {
            visited[i] = arr[i];
            comb(i + 1, cnt + 1, pick, visited, arr);
        }
    }
}
