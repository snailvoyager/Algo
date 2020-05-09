package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1929_Math {
	static int M, N;
	static boolean[] Primes;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Primes = new boolean[N+1];
		
		Primes[1] = true;
		for(int i=2; i<=N; i++) {
			if(Primes[i])	continue;
			for(int j=i+i; j<=N; j+=i) {
				Primes[j] = true;
			}
		}
		
		for(int i=M; i<=N; i++) {
			if(!Primes[i])
				System.out.println(i);
		}
	}

}
