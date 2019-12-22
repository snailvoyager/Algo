package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10216 {

	static int T, N;
	static int[] P;
	static int[][] M;
	
	public static int rep(int n){
		while(P[n] != n)
			n = P[n];
		
		return n;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T; test_case++){
			N = Integer.parseInt(br.readLine());
			M = new int[N+1][3];
			P = new int[N+1];
			int Answer = 0;
			
			for(int i=1; i<=N; i++){		//root배열 초기화
				P[i] = i;
			}
			
			for(int i=1; i<=N; i++){
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				M[i][0] = x;
				M[i][1] = y;
				M[i][2] = r;
			}
			
			for(int i=1; i<=N; i++){
				for(int j=i+1; j<=N; j++){
					int a = M[i][0] - M[j][0];
					int b = M[i][1] - M[j][1];
					int c = M[i][2] + M[j][2];
					
					if(a*a + b*b <= c*c){
						P[rep(j)] = rep(i);
					}
				}
			}
			
			for(int i=1; i<=N; i++){
				if(P[i] == i)
					Answer++;
			}
			
			System.out.println(Answer);
		}
	}

}
