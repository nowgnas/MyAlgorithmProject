
import java.util.Scanner;
public class cataldfs {
	static int H, W;
	static long cnt;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		H=scann.nextInt();
		W=scann.nextInt();
		cnt=0L;
		dfs(0,0);
		System.out.println(cnt);
	}
	private static void dfs(int h, int w) {
		
		if(h>H || w>W){ return ;}
		if(h==H && w==W){
			cnt++;
			return ;
		}
		
		dfs(h+1,w);
		// (h,w)위치에서 (h, w+1)로 갈수 있는가 
		// H/W 아래위치해야함
		if(1.0*H/W<=1.0*h/(w+1)){
			dfs(h,w+1);
		}
	}
}