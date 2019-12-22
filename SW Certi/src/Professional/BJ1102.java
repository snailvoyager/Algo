package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1102 {
	static int N, P, cur;
	static int[][] W;
	static char[] S;
	static int[] dp;
	static final int INF = 1000000000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		W = new int[N+1][N+1];
		S = new char[N+1];
		dp = new int[1<<16];
		
		for(int i=0; i<(1<<16); i++){
			dp[i] = -1;
		}
		
		for(int i=1; i<=N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++){
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		S = st.nextToken().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		P = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		for(int i=0; i<N; i++){
			if(S[i] == 'Y'){
				cnt++;
				cur = cur | (1 << (i+1));
			}
		}
		
		if(cnt == 0){
			if(P == 0)
				System.out.println(0);
			else
				System.out.println(-1);
		} else if(cnt >= P){
			System.out.println(0);
		} else{
			System.out.println(func(cnt, cur));
		}
		
	}
	
	public static int func(int num, int stat){		//num:������ ����, stat:���� ����
//		System.out.println(num + ", " + stat + "dp: " + dp[stat]);
		if(num == P)			//P������ŭ ���� ���̸�
			return 0;
		
		if(dp[stat] != -1)		//�̹� ����� ����
			return dp[stat];
		
		int ref = INF;
		
		for(int i=1; i<=N; i++){
			if((stat & (1 << i)) != 0){			//i������ ���� ���̸� ���� ������ ã�Ƽ� ON �������
				for(int j=1; j<=N; j++){
					if(i == j)
						continue;
					
					if((stat & (1 << j)) == 0){	//j������ �����̸� i�������� �������ִ� �����
						ref = Math.min(ref, func(num+1, stat | (1 << j)) + W[i][j]);
					}
				}
			}
		}
		dp[stat] = ref;
		return dp[stat];
	}
}
