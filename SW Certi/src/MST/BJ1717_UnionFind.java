package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1717_UnionFind {
	
	static int N, M;
	static int[] P;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = new int[N+1];
		
		for(int i=1; i<=N; i++) {	//배열 초기화
			P[i] = i;
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			if(x == 0) {
				union(y,z);
			} else {
				int yRoot = find(y);
				int zRoot = find(z);
				if(yRoot == zRoot)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
	
	public static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		
		if(A!=B) {
			P[B] = A;
		}
	}
	
	public static int find(int n) {
		if(n == P[n])
			return n;
		else {
			int p = find(P[n]);
			P[n] = p;
			return p;
		}
	}

}
/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
 */
