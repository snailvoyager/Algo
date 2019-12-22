package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_타일붙이기_DP {
	
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
1x2, 2x2, 2x3 크기의 타일을 nx2 크기의 공간에 붙이는 경우의 수를 구하세요.  답이 매우 큰 숫자일 수 있으므로, C는 long long형, Java는 long형을 사용해야 할 수도 있습니다.
입력
1<n<30
출력
#테스트케이스 번호와 답을 출력합니다.

3
5
8
10

#1 28
#2 277
#3 1278

*/