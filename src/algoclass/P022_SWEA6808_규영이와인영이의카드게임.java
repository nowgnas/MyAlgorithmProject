package 이상원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P022_SWEA6808_규영이와인영이의카드게임 {
    static int N, totalCnt;
    static boolean[] isSelected;
    static int[] g;
    static int[] in;
    static boolean[] check;
    static int[] numbers;
    static int match;
    static int answer;
    static int draw;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());


        for (int i = 1; i <= tc; i++) {
            numbers = new int[9];
            g = new int[9];
            check = new boolean[18];
            in = new int[9];
            isSelected = new boolean[10];
            match = 0;
            answer = 0;
            draw = 0;


            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                g[j] = Integer.parseInt(st.nextToken());
                check[g[j] - 1] = true;
            }
            int idx = 0;
            for (int k = 0; k < 18; k++) {
                if (!check[k]) in[idx++] = k + 1;
            }
            // 입력 받기 완료
            perm(0);
            sb.append("#").append(i).append(" ").append(answer).append(" ").append((match - draw - answer));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void perm(int cnt) { // permutation 다시 보기
        if (cnt == 9) {
            match++;
            int gSum = 0;
            int inSum = 0;
            for (int i = 0; i < 9; i++) {
                if (g[i] < numbers[i]) {
                    inSum += g[i] + numbers[i];
                } else {
                    gSum += g[i] + numbers[i];
                }
            }
            if (gSum > inSum) answer++;
            if (gSum == inSum) draw++;
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (isSelected[i]) continue;
            numbers[cnt] = in[i];
            isSelected[i] = true;
            perm(cnt + 1);
            isSelected[i] = false;
        }
    }
}
