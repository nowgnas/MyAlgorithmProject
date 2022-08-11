package algorithm.class0808.요세푸스문제3;


import java.util.*;

/*
 * https://www.acmicpc.net/problem/1158
 * */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            queue.add(i);
        }
        int[] arr = new int[n];
        int index = 0;
        int watch = 0;
        while (queue.isEmpty()) {

            index++;
            arr[index] = queue.remove(index - 1);
            watch = index - 2;

        }


    }
}