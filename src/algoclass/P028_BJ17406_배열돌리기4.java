package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P028_BJ17406_배열돌리기4 {
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

            //맨오른쪽줄을 큐에다가 더함
            for (int j = r - i + 1; j < r + i; j++) {
                indexList.add(new int[]{j, c + i});
                queue.add(board[j][c + i]);
            }

            //맨 밑줄을 큐에다가 더함
            for (int j = c + i; j > c - i - 1; j--) {
                indexList.add(new int[]{r + i, j});
                queue.add(board[r + i][j]);
            }

            //맨 왼쪽줄을 큐에다가 더함
            for (int j = r + i - 1; j > r - i; j--) {
                indexList.add(new int[]{j, c - i});
                queue.add(board[j][c - i]);
            }

            //하나를 빼고 큐에 다시 더한다 = 시계방향으로 움직임
            queue.addFirst(queue.removeLast());

            //큐에 넣은 원소들을 인덱스 리스트에서 하나씩 가져와서 값을 초기화 한다.
            for (int[] ints : indexList) {
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


    // 순열을 생성하는 메서드
    private static void permutation(int count, int[] per) {

        // 순열이 완성되면
        if (count == k) {
            //임시보드에 원본 보드의 내용을 복사한다.
            for (int i = 0; i < n; i++) {
                System.arraycopy(originalBoard[i], 0, board[i], 0, originalBoard[i].length);
            }
            // 순서대로 연산을 수행
            for (int i = 0; i < k; i++) {
                int[] ints = operator[per[i]];
                r = ints[0];
                c = ints[1];
                s = ints[2];

                //연산을 수행하는 메서드
                solve();
            }


            //연산 수행후 각 행의 합을 정답과 비교한다.

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
