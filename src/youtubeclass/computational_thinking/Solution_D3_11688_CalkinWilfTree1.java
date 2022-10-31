import java.util.Scanner;

public class Solution_D3_11688_CalkinWilfTree1 {

	static int TC;
	static int A;
	static int B;
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		TC=scann.nextInt();
		for (int t = 1; t <= TC; t++) {
			String s=scann.next();
			int[] res=cakinwilf(s,1,1);
			int gcd=gcd(res[0], res[1]);
			System.out.println("#"+t+" "+res[0]/gcd+" "+res[1]/gcd);
		}
	}

	static int[] cakinwilf(String s, int a, int b) {
		
		if(s.length()==1){
			if(s.charAt(0)=='L'){
				int [] res=new int[]{a,a+b};
				return res;
			}else{
				int [] res=new int[]{a+b,b};
				return res;
			}
		}else {
			if(s.charAt(0)=='L'){
				return cakinwilf(s.substring(1),a,a+b);
			}else{
				return  cakinwilf(s.substring(1),a+b,b);
			}
		}
		
		
	}

	public static int gcd(int a, int b){
		if(a==0 )return b;
		else if(b==0) return a;
		else if(a==b){ 
			return a ;
		}else if(a>b){ 
			return gcd(a%b,b) ;
		}else return gcd(a,b%a) ;
	}
}
