package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_Ÿ�Ϻ��̱�_DP {
	
	static int N, T;
	static long Answer;
	static long[] D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
			Answer = 0;
			N = Integer.parseInt(br.readLine());
			D = new long[31];
//			Answer = func(N);
			
			D[1] = 1;
			D[2] =3;
			D[3] = 6;
			
			for(int i=4; i<=N; i++){
				D[i] = D[i-1] + D[i-2]*2 + D[i-3];
			}
			Answer = D[N];
			
			System.out.println("#"+ tc + " " + Answer);
		}
	}
	
	public static long func(long n){
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		if(n == 2)
			return 3;
		if(n == 3)
			return 6;
		return func(n-1) + func(n-2)*2 + func(n-3);
	}
	
}
/*
1x2, 2x2, 2x3 ũ���� Ÿ���� nx2 ũ���� ������ ���̴� ����� ���� ���ϼ���.  ���� �ſ� ū ������ �� �����Ƿ�, C�� long long��, Java�� long���� ����ؾ� �� ���� �ֽ��ϴ�.
�Է�
1<n<30
���
#�׽�Ʈ���̽� ��ȣ�� ���� ����մϴ�.

3
5
8
10

#1 28
#2 277
#3 1278

*/