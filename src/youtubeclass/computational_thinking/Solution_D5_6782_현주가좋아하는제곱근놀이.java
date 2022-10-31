package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D5_6782_현주가좋아하는제곱근놀이 {  //D5

	public static int T=0;
	public static long N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine().trim());
		for (int iT = 1; iT <= T; iT++) {
			N=Long.parseLong(br.readLine().trim());
			long count=0L;
			while(N!=2L) {
				long K=((long)Math.sqrt(N));
				if(K*K==N) {
					N=K;
					count++;
				}else {
					long M=(K+1)*(K+1);
					count+=(M-N);
					N=M;
				}
			}
			System.out.printf("#%d %d\n",iT,count);
		}
		
	}
	
}