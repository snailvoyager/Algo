package ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2309_BF {
	static int[] Input = new int[9];
	static int[] Temp = new int[7];
	static int Sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<9; i++) {
			int n = Integer.parseInt(br.readLine());
			Input[i] = n;
			Sum += n;
		}
		//combi(9, 7);
		func();
	}
	
	public static void func() {
		loop1:
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(i == j)
					continue;
				
				if(Sum - Input[i] - Input[j] == 100) {		//두개를 뺀 값이 100이면 나머지가 정답
					Input[i] = 0;
					Input[j] = 0;
					
					break loop1;
				}
			}
		}
		Arrays.sort(Input);
		for(int i : Input) {
			if(i != 0)
				System.out.println(i);
		}
	}

	public static void combi(int n, int r) {		//조합
		if(r == 0) {
			int sum = 0;
			for(int i=0; i<Temp.length; i++) {
				sum += Temp[i];
			}
			if(sum == 100) {
				Arrays.sort(Temp);
				for(int i:Temp)
					System.out.println(i);
				System.exit(0);
			}
			return;
		} else if(n < r) {
			return;
		} else {
			Temp[r-1] = Input[n-1];
			combi(n-1, r-1);
			combi(n-1, r);
		}
	}
}
/**
8
9
10
11
12
24
26
23
27
**/