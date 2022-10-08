package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P014_BJ2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            deque.add((i+1));
        }

        while (deque.size()>1){
            deque.removeFirst();
            deque.add(deque.getFirst());
            deque.removeFirst();
        }
        System.out.println(deque.getFirst());
    }
}
