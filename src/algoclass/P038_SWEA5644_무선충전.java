package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.max;

public class P038_SWEA5644_무선충전 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[][] direction = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int m, a;
    private static int[] moveA, moveB;
    private static int[][] ap;
    private static int ax = 1, ay = 1, bx = 10, by = 10;
    private static Set<Integer> setA;
    private static Set<Integer> setB;
    private static int answer;


    public static void main(String[] args) throws IOException {

        int testcase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testcase; t++) {
            input();
            checkSet();
            calcMax();
            for (int i = 0; i < m; i++) {
                move(moveA[i], moveB[i]);
                checkSet();
                calcMax();
            }
            System.out.printf("#%d %d\n", t + 1, answer);
        }
    }

    private static void input() throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = array[0];
        a = array[1];
        ap = new int[a][];
        moveA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        moveB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        setA = new HashSet<>();
        setB = new HashSet<>();
        answer = 0;
        ay = ax = 1;
        by = bx = 10;
        for (int i = 0; i < a; i++) {
            ap[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

    }

    private static void calcMax() {
        int max_val = 0;
        if (setA.isEmpty()) {
            for (Integer integer : setB) {
                max_val = max(max_val, ap[integer][3]);
            }
        } else if (setB.isEmpty()) {
            for (Integer integer : setA) {
                max_val = max(max_val, ap[integer][3]);
            }
        } else {
            for (Integer a_idx : setA) {
                for (Integer b_idx : setB) {
                    if (b_idx.equals(a_idx)) {
                        max_val = max(max_val, ap[a_idx][3]);
                    } else {
                        max_val = max(max_val, ap[a_idx][3] + ap[b_idx][3]);
                    }
                }
            }
        }
        setA.clear();
        setB.clear();

        answer += max_val;
    }

    private static void checkSet() {
        for (int i = 0; i < a; i++) {
            if (distCheck(ax, ay, ap[i][0], ap[i][1], ap[i][2])) {
                setA.add(i);
            }
            if (distCheck(bx, by, ap[i][0], ap[i][1], ap[i][2])) {
                setB.add(i);
            }
        }
    }

    private static void move(int aIdx, int bIdx) {
        ay += direction[aIdx][0];
        ax += direction[aIdx][1];
        by += direction[bIdx][0];
        bx += direction[bIdx][1];
    }


    private static boolean distCheck(int x, int y, int x1, int y1, int c) {
        return Math.abs(x - x1) + Math.abs(y - y1) <= c;
    }
}
