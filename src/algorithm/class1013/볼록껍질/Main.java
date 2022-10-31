package algorithm.class1013.볼록껍질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    // Convex Hull Algorithm
    //
    // 1. 껍질을 만드는 시작 점을 찾기 .. y 값이 가장 작은 점 .. 두 개 이상일땐 x값이 가장 작은 점 ..
    // 2. 시작점을 기준으로 반시계 방향으로 정렬
    // 3. 정렬 후 스택을 이용하여 컨벡스 홀 알고리즘 시작 ! .. 다각형에 포함되는 점일때 stack 에 쌓인다
    //
    // 참고 : https://johoonday.tistory.com/205
    //      https://coder-in-war.tistory.com/entry/Baekjoon-JAVA1708-%EB%B3%BC%EB%A1%9D%EA%BB%8D%EC%A7%88

    static class node {
        long x, y;

        public node(long x, long y) {
            super();
            this.x = x;
            this.y = y;
        }

    }

    static node first = new node(40001, 40001);

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 점의 개수
        ArrayList<node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s[] = bf.readLine().split(" ");
            list.add(new node(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        } // 입력 완료

        // 점들 중 x 좌표값이나 y 좌표값이 가장 작은 점을 기준으로 잡는다
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).y < first.y) {
                first = list.get(i);
            } else if (list.get(i).y == first.y) {
                if (list.get(i).x < first.x)
                    first = list.get(i);
            }
        }

        // 기준점과 나머지 점들이 ccw로 반시계방향(좌회전)이 되도록 정렬, 만약 일직선상에 있으면 거리가 증가하게끔 정렬
        list.sort(new Comparator<node>() {
            public int compare(node second, node third) {
                int ccwR = ccw(first, second, third);
                // 반시계 방향
                if (ccwR > 0) return -1; // 오름차순
                else if (ccwR < 0) return 1; // 내림 차순
                else if (ccwR == 0) {
                    long distR1 = dist(first, second);
                    long distR2 = dist(first, third);

                    if (distR1 > distR2) return 1;
                }
                return -1;
            }
        });


        // 그라함 스캔 알고리즘
        Stack<node> stack = new Stack<node>();
        stack.add(first);

        for (int i = 1; i < list.size(); i++) {
            // 시계 방향이면 제거한다
            while (stack.size() > 1 && ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), list.get(i)) <= 0) {
                stack.pop();
            }
            stack.add(list.get(i));
        }

        System.out.println(stack.size());
    }

    static long dist(node a, node b) {
        return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
    }

    // ccw 알고리즘 : 시계방향 -1, 일직선 0, 반시계 1
    static int ccw(node a, node b, node c) {
        long ccwR = (a.x * b.y + b.x * c.y + c.x * a.y) - (b.x * a.y + c.x * b.y + a.x * c.y);
        if (ccwR > 0)
            return 1;
        if (ccwR < 0)
            return -1;
        return 0;
    }

}
/*
 * 1. 점들 중 껍질을 만들기 시작하는 점을 찾는다
 *
 * 2. 시작점을 기준으로 다른 점들을 반세계 방향으로 정렬한다
 * - 가장 아래 있는 점들 중 가장 왼쪽에 있는 점
 *
 * 3. 반시계 방향으로 */