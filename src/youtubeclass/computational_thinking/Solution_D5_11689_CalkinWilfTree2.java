import java.util.Scanner;

public class Solution_D5_11689_CalkinWilfTree2 {

	static int TC;
	static long num;
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		TC=scann.nextInt();
		for (int t = 1; t <= TC; t++) {
			long a=scann.nextLong();
			long b=scann.nextLong();
		    num=calkin(a,b,0L);
			System.out.println("#"+t+" "+num);
		}
	}

	

	static long calkin(long a, long b, long tot) {
		if(a==1 && b==1){
			return 0;
		}else if(a==1){ 
			return tot+b-1;
		}else if(b==1){ 
			return tot+a-1;
		}else if(a<b){
			long mok=b/a;
			long div=b%a;
			return calkin(a,div,tot+mok);
		}else if(a>b){
			long mok=a/b;
			long div=a%b;
			return calkin(div,b,tot+mok);
		}
		return 0L;
	}



}
