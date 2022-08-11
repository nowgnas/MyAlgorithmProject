package algorithm.youtubeclass.class0811.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CompleteBinaryTree {
    /*
     * 완전 이진트리로 구현
     * */
    private char[] nodes;
    private int lastIndex; // 마지막 노드의 인덱스
    private final int SIZE;

    public CompleteBinaryTree(int size) {
        SIZE = size;
        nodes = new char[size + 1]; // 1인덱스 부터 사용할 것
    }

    public boolean add(char e) {
        // 완전 이진트리에 맞게 추가
        if (lastIndex == SIZE) return false; // 꽉 차면 false
        nodes[++lastIndex] = e; // 공간 있으면 넣기
        return true;
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList();
        queue.offer(1); // 루트 노드 인덱스 부터

        while (!queue.isEmpty()) { // 비어 있지 않을 때 까지
            int current = queue.poll();
            System.out.println(nodes[current] + " ");

            // 현재 방문 노드의 자식 노드들을 대기열에 넣기
            if (current * 2 <= lastIndex) queue.offer(current * 2); // 왼쪽 자식
            if (current * 2 + 1 <= lastIndex) queue.offer(current * 2 + 1); // 오른쪽 자식
        }
        System.out.println();
    }

    public void bf2() {
        Queue<Integer> queue = new LinkedList();
        queue.offer(1); // 루트 노드 인덱스 부터

        while (!queue.isEmpty()) { // 비어 있지 않을 때 까지
            int size = queue.size(); // 큐의 크기 확인

            while (--size >= 0) { // 반복 진입 전 구한 큐의 크기 만큼만 반복
                int current = queue.poll(); // 방문차례인 대상 정보 꺼내기
                System.out.println(nodes[current] + " ");

                // 현재 방문 노드의 자식 노드들을 대기열에 넣기
                if (current * 2 <= lastIndex) queue.offer(current * 2); // 왼쪽 자식
                if (current * 2 + 1 <= lastIndex) queue.offer(current * 2 + 1); // 오른쪽 자식

            }
        }
        System.out.println();
    }

    public void dfs() {
        Stack<Integer> queue = new Stack<>();
        queue.push(1); // 루트 노드 인덱스 부터

        while (!queue.isEmpty()) { // 비어 있지 않을 때 까지
            int current = queue.pop();
            System.out.println(nodes[current] + " ");

            // 현재 방문 노드의 자식 노드들을 대기열에 넣기
            if (current * 2 <= lastIndex) queue.push(current * 2); // 왼쪽 자식
            if (current * 2 + 1 <= lastIndex) queue.push(current * 2 + 1); // 오른쪽 자식
        }
        System.out.println();
    }

    public void dfsByPreOrder(int current) {
        System.out.println(nodes[current] + " "); // 방문해서 해야할일 처리
        if (current * 2 <= lastIndex) dfsByPreOrder(current * 2);
        if (current * 2 + 1 <= lastIndex) dfsByPreOrder(current * 2 + 1);


    }

    public void dfsByInOrder(int current) {
        if (current > lastIndex) return;

        dfsByInOrder(current * 2);
        System.out.println(nodes[current] + " "); // 방문해서 해야할일 처리
        dfsByInOrder(current * 2 + 1);

    }

    public void dfsByPostOrder(int current) {
        if (current > lastIndex) return;

        dfsByPostOrder(current * 2);
        dfsByPostOrder(current * 2 + 1);
        System.out.println(nodes[current] + " "); // 방문해서 해야할일 처리

    }


}
