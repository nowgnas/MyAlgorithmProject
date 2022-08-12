package algorithm.class0812.요리사;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[][] board;
    private static List<int[]> list;
    private static int mid;
    private static int[] visit;
    private static List<Integer> FoodA, FoodB;

    private static int answer;

    public static void main(String[] args) throws IOException {
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testcase; t++) {
            n = Integer.parseInt(br.readLine());
            mid = n / 2;
            list = new ArrayList<>();
            board = new int[n][];
            visit = new int[n];
            answer = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            combination(0, 0);
            System.out.printf("#%d %d\n", t + 1, answer);
        }

    }

    // 조합 생성

    private static void combination(int count, int start) {
        if (count > mid) {
            return;
        }


        // 조합이 완성되었을 경우
        if (count == mid) {

            //인덱스를 저장할 리스트
            FoodA = new ArrayList<>();
            FoodB = new ArrayList<>();

            // 고른 재료들을 각 리스트에 넣는다.
            for (int i = 0; i < n; i++) {
                if (visit[i] == 0) {
                    FoodB.add(i);
                } else {
                    FoodA.add(i);
                }
            }
            int ASum = 0;

            // 리스트에서 꺼내면서 맛을 계산
            for (int i = 0; i < FoodA.size(); i++) {
                for (int j = i + 1; j < FoodA.size(); j++) {
                    int idx1 = FoodA.get(i);
                    int idx2 = FoodA.get(j);
                    ASum += board[idx1][idx2] + board[idx2][idx1];
                }
            }
            int BSum = 0;

            // 리스트에서 꺼내면서 맛을 계산한다.
            for (int i = 0; i < FoodB.size(); i++) {
                for (int j = i + 1; j < FoodB.size(); j++) {
                    int idx1 = FoodB.get(i);
                    int idx2 = FoodB.get(j);
                    BSum += board[idx1][idx2] + board[idx2][idx1];
                }
            }
            answer = Math.min(Math.abs(ASum - BSum), answer);

        }

        for (int i = start; i < n; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                combination(count + 1, i + 1);
                visit[i] = 0;
            }
        }
    }
}
