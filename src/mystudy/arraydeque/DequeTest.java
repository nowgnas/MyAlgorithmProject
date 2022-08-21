package mystudy.arraydeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.offer(1);
        deque.offer(0);
        deque.offer(4);
        deque.offer(3);
        deque.add(5);
        deque.add(8);
        deque.offerFirst(10);
        System.out.println(deque);
    }
}
