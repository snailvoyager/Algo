package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1978_Math {

	static int N, Answer;
	static int[] Arr;
	static boolean[] Primes;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			Arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(Arr);
		int n = Arr[N-1];		//가장 큰수
		
		//checkPrimes(n);
		for(int i=0; i<N; i++) {
			if(checkPrimes2(Arr[i]))
				Answer++;
		}
		
		System.out.println(Answer);
	}
	
	public static boolean checkPrimes2(int n) {
		if(n == 1)	return false;
		for(int i=2; i<=n/2; i++) {		//n/2 까지 나누었을 때 나누어지는 약수가 없어야함
			if(n % i == 0)
				return false;
		}
		return true;
	}
	
	public static void checkPrimes(int n) {		//에라토스테네스의 체
		Primes = new boolean[n+1];
		Primes[1] = true;		//false 가 소수
		
		for(int i=2; i<=n; i++) {
			if(Primes[i])	continue;	//이미 확인된 배수는 패스
			for(int j=i+i; j<=n; j+=i) {		//소수가 아닌 i 배수 체크
				Primes[j] = true;
			}
		}
		
		for(int i=0; i<N; i++) {
			if(!Primes[Arr[i]])
				Answer++;
		}
		//System.out.println(Arrays.toString(Primes));
	}

}
