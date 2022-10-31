import java.util.Arrays;

public class ExtendedEuc {

	public static void main(String[] args) {
		eeuc(1029,1071);
		eeuc(119*59,60);
		System.out.println(Arrays.toString(exgcd(1029,1071)));
	}
	
	 public static long[] exgcd(long a, long b) {
	    if (b == 0) return new long[] {a, 1, 0};
	    else {
	      long[] coef = exgcd(b, a % b);
	      long tmp = coef[1] - coef[2] * (a / b);
	      coef[1] = coef[2];
	      coef[2] = tmp;
	      return coef;
	    }
	  }
	static void eeuc(int a, int b){
	    int r0=a, r1=b;
		int s0=1, s1=0;
		int t0=0, t1=1;
		int temp=0,q=0;
	  
		while(r1>0){
		    q=r0/r1;
		    temp=r0;
		    r0=r1;
		    r1=temp-r1*q;
		    temp=s0;
		    s0=s1;
		    s1=temp-s1*q;
		    temp=t0;
		    t0=t1;
		    t1=temp-t1*q;
		    //System.out.printf("%d %d %d %d %d %d\n", r0,r1,s0,s1,t0,t1);
		}
/*		System.out.printf("%d %d %d %d %d %d\n"
				, r0,r1,s0,s1,t0,t1);*/
		System.out.printf("(%d)*(%d)+(%d)*(%d)=%d, (%d)\n",
				a,s0,b,t0,r0,a*s0+b*t0);
		
		/*System.out.printf("(%d)*(%d)+(%d)*(%d)=0, (%d)\n",
				a,s1,b,t1,a*s1+b*t1);*/
		
	}
}
