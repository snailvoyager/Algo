package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2156_DP {
	static int N;
	static int[] A;
	static int[][] D;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		D = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		D[1][0] = 0;		//마시지 않았을 때
		D[1][1] = A[1];		//첫째잔으로 마셨을 때
		D[1][2] = A[1];		//둘째잔으로 마셨을 때
		
		for(int i=2; i<=N; i++) {
			int temp = Math.max(Math.max(D[i-1][0], D[i-1][1]), D[i-1][2]);
			D[i][0] = temp;
			D[i][1] = D[i-1][0] + A[i];
			D[i][2] = D[i-1][1] + A[i];
		}
		
		int Answer = Math.max(Math.max(D[N][0], D[N][1]), D[N][2]);
		
		System.out.println(Answer);
	}
}
