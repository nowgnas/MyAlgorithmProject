
import java.util.Scanner;
public class Main_BOJ_11727_2n타일링 {
	public static void main(String[] args) {
		int T=10007;
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		int[] p=new int[N+2];
		p[1]=1;
		p[2]=3;
		for (int i = 3; i <N+1; i++) {
			if(i>2 && i%2==0 ){
				p[i]=(((p[i/2]%T)*(p[i/2]%T)%T)%T
						+((2*(p[i/2-1]%T)%T)*(p[i/2-1]%T)%T)%T)%T;
			}else if(i>2 && i%2==1) {
				p[i]=((p[i-1]%T)+(2*(p[i-2]%T))%T)%T;
			}
		}
		System.out.println(p[N]);
/*		for (int i = 1; i < N+1; i++) {
			System.out.println(p[i]);
		}*/
		
	}
	
}
