package study.week8.순열의순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        boolean[] visited = new boolean[21];
        long[] factorial = new long[21];

        factorial[0] = 1;
        for (int i = 1; i < 21; i++) {
            factorial[i] = factorial[i - 1] * i; // 팩토리얼 가짓수  경우의 수를 구한다
        }

        if (num == 1) {
            // k번째 순열 최대 20이므로 long으로 받음
            long k = Long.parseLong(st.nextToken());
            for (int i = 0; i < n; i++) { // 팩토리얼 가짓수
                for (int j = 1; j <= n; j++) { // 1부터 n까지 확인
                    if (visited[j]) continue; // 순열에 이미 존재하면 다음 숫자 확인
                    if (factorial[n - i - 1] < k) k -= factorial[n - i - 1]; // 팩토리얼 값이 k보다 작으면 k에서 팩토리얼 값을 빼준다
                    else {
                        // 팩토리얼 값이 k보다 크면 해당하는 원소의 숫자를 찾은것이므로
                        // a[i]에 저장하고 순열에 존재하는 숫자를 체크
                        arr[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long ans = 1L;

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < arr[i]; j++) { // 1부터 해당하는 원소까지 팩토리얼 값을 늘려가며 더해줌
                    if (!visited[j]) ans += factorial[n - i - 1];
                }
                visited[arr[i]] = true;
            }
            System.out.println(ans);
        }
    }
}
