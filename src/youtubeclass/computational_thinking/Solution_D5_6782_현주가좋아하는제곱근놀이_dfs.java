package d5;

import java.util.Scanner;

public class Solution_D5_6782_현주가좋아하는제곱근놀이_dfs {
	static int TC;
	static long N;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextLong();

			ans = 0;
			dfs(N, 0);

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void dfs(long n, int cnt) {
		if (n == 2) {
			ans = cnt;
			return;
		}

		double tmp =  Math.sqrt(n);
		if ((int)tmp == tmp) { // 현재 n이 제곱수였다면 바로 루트씌우면 됨.
			dfs((int)tmp, cnt + 1);
		} else { // 그게 아니면 제곱수까지 1 더하는 연산 수행하고 나서 루트씌워야함.
			long tmp2 = (int) tmp;
			cnt += (tmp2 + 1) * (tmp2 + 1) - n;
			dfs(tmp2 + 1, cnt + 1);
		}
	}

}
