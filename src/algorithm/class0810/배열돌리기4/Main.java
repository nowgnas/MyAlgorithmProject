package algorithm.class0810.배열돌리기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, k, r, c, s;
    static int[][] board;
    static int[][] originalBoard;
    static int[][] operator;
    static int[] visit;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        k = array[2];
        board = new int[n][m];
        originalBoard = new int[n][];
        operator = new int[k][];
        visit = new int[k];
        for (int i = 0; i < n; i++) {
            originalBoard[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < k; i++) {

            int[] array1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            array1[0] -= 1;
            array1[1] -= 1;
            operator[i] = array1;
            // permutation
        }
        permutation(0, new int[k]);
        System.out.println(answer);

    }


    private static void solve() {

        // 9 3 8 2 3 5 2 3
        for (int i = s; i > 0; i--) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            List<int[]> indexList = new ArrayList<>();
            // 맨윗줄 리스트에다 더함
            for (int j = c - i; j < c + i + 1; j++) {
                indexList.add(new int[]{r - i, j});
                queue.add(board[r - i][j]);
            }
            for (int j = r - i + 1; j < r + i; j++) {
                indexList.add(new int[]{j, c + i});
                queue.add(board[j][c + i]);
            }
            for (int j = c + i; j > c - i - 1; j--) {
                indexList.add(new int[]{r + i, j});
                queue.add(board[r + i][j]);
            }
            for (int j = r + i - 1; j > r - i; j--) {
                indexList.add(new int[]{j, c - i});
                queue.add(board[j][c - i]);
            }
            queue.addFirst(queue.removeLast());
            for (int j = 0; j < indexList.size(); j++) {
                int[] ints = indexList.get(j);
                int y = ints[0];
                int x = ints[1];

                Integer integer = queue.removeFirst();
                board[y][x] = integer;
            }
        }

        // 3 8 2
        // 9 4 3
        // 3 2 5


    }

    private static void permutation(int count, int[] per) {
        if (count == k) {
            for (int i = 0; i < n; i++) {
                System.arraycopy(originalBoard[i], 0, board[i], 0, originalBoard[i].length);
            }
            for (int i = 0; i < k; i++) {
                int[] ints = operator[per[i]];
                r = ints[0];
                c = ints[1];
                s = ints[2];
                solve();
            }

            for (int i = 0; i < n; i++) {
                int sum = Arrays.stream(board[i]).sum();
                answer = Math.min(answer, sum);
            }
            return;
        }
        for (int i = 0; i < k; i++) {
            if (visit[i] == 0) {
                per[count] = i;
                visit[i] = 1;
                permutation(count + 1, per);
                visit[i] = 0;
            }

        }

    }
}
