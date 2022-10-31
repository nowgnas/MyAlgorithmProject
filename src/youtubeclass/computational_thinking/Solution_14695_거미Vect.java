
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Solution_14695_거미Vect {
	// <v> =(i,j,k) 공간 벡터
	static class Vect{
		long i;
		long j;
		long k;
		public Vect(long i, long j, long k) {
			this.i = i;
			this.j = j;
			this.k = k;
		}
		@Override
		public String toString() {
			return "Vect [i=" + i + ", j=" + j + ", k=" + k + "]";
		}
		
	}
	static List<Vect> vects;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			if(N<=3) {
				for (int i = 0; i < N; i++) {
					br.readLine();
				}
				sb.append("#" + t + " " + ("TAK")).append("\n");
				continue;
			}
			vects=new ArrayList<>();
			StringTokenizer st=new StringTokenizer(br.readLine());
			long p0i=Long.parseLong(st.nextToken());
			long p0j=Long.parseLong(st.nextToken());
			long p0k=Long.parseLong(st.nextToken());
			Vect v0=new Vect(p0i, p0j, p0k);  // 기준벡터
			
			for (int i = 1; i < N; i++) {
				st=new StringTokenizer(br.readLine());
				long x=Long.parseLong(st.nextToken());
				long y=Long.parseLong(st.nextToken());
				long z=Long.parseLong(st.nextToken()); 
				vects.add(new Vect(x-v0.i, y-v0.j, z-v0.k));  // 기준에서 방향벡터
			}
			// 같은 벡터가 없으르로 0벡터 없다. 
			Vect first=vects.get(vects.size()-1);
			Vect cross= noZeroCross(vects, first);        //first와 평행 벡터 제거 =>0이 아닌 법선벡터
			if(cross==null) {  // 일직선
				sb.append("#" + t + " " + ("TAK")).append("\n");
				continue;
			} 
			boolean isS=true;
			for (Vect vv: vects) {
				if(inner(cross,vv)!=0) {               // 평면과 수직이면서 평형한곳
					isS=false ;
					break;
				}
			}
			if(isS) {
				sb.append("#" + t + " " + ("TAK")).append("\n");
			}else {
				sb.append("#" + t + " " + ("NIE")).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static boolean isParall(Vect v0, Vect v1) {
		Vect crossresult=cross(v1, v0);
		return norm(crossresult)==0;
	}
	private static Vect noZeroCross(List<Vect> vs, Vect basev) {
		for (int i=vs.size()-1;i>=0;i--) {
			Vect now=vs.get(i);
			if(isParall(basev,now)) {        // 평행
				vs.remove(i);  // 평행 벡터 제거
				continue;
			}
			return cross(basev,now);
		}
		return null;
	}

	private static Vect cross(Vect v1, Vect v2 ) {
		long i=0L+v2.j*v1.k-v1.j*v2.k;
		long j=0L+v1.i*v2.k-v2.i*v1.k;
		long k=0L+v2.i*v1.j-v1.i*v2.j;
		return new Vect(i, j, k);
	}
	private static long inner(Vect v1, Vect v2 ) {
		long i=0L+v1.i*v2.i;
		long j=0L+v1.j*v2.j;
		long k=0L+v1.k*v2.k;
		return i+j+k;
	}
	private static long norm(Vect v) {
		long i=0L+v.i;
		long j=0L+v.j;
		long k=0L+v.k;
		// 28/29 -> long*long의 범위를 넘어섬
		return Math.abs(i)+Math.abs(j)+Math.abs(k);
	}
}
/*
5
3
1 0 0
0 1 0
0 0 1
4
1 0 0
0 1 0
0 0 1
1 -1 1
5
1 0 0
0 1 0
0 0 1
0 1 0
0 0 1
6
1 0 0
0 1 0
0 0 1
0 1 0
0 0 1
2 3 4
7
1 0 0
0 1 0
0 0 1
0 1 0
0 0 1
2 3 4
2 3 -4

*/