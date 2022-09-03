package study.week5.동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] inputs;
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        inputs = new int[N];

        for (int i = N; i > 0; i--) {
            st = new StringTokenizer(br.readLine());
            inputs[i - 1] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int item :
                inputs) {
            if (K >= item) {
                int div = K / item;
                answer += div;
                K -= item * div;
            }
        }
        System.out.println(answer);
    }
}
