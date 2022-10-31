

import java.math.BigInteger;
import java.util.Scanner;

public class Solution_D4_7466_팩토리얼과공약수_유클리드호제법2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			long N = sc.nextInt();
			long K = sc.nextInt();
			
			long tmp = 1;
			
			while( N>= 1 && K!= 1) {
				long gcd = gcd(N, K);
				K /= gcd;
				N--;
				tmp *= gcd;
			}
			System.out.println("#"+tc+" "+tmp);

		}
	}
	public static long gcd(long a, long b){
		if(a==b || b==0L){
			return a;
		}else if(a>b){ return gcd(b,a%b);}
		else { return gcd(a,b%a);}
	}
}
