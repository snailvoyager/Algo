package im;

import java.util.Arrays;

public class Combination {

	static int[] T;
	static boolean[] Visit = new boolean[5];
	static int[] D = {1,2,3,4,5};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int r = 3;
		
		T = new int[r];
		combi(n,r);
		System.out.println();
		combi2(n, r, 0);
		System.out.println();
		combi3(n, r, 0);
		System.out.println();
		combi4(r);
	}
	
	public static void combi(int n, int r){			//재귀
		if(r == 0){
			System.out.println(Arrays.toString(T));
		} else if(n < r){
		} else{
			T[r-1] = D[n-1];
			combi(n-1, r-1);
			combi(n-1, r);
		}
	}
	
	public static void combi2(int n, int r, int start) {	//백트래킹
		if(r == 0) {
			for(int i=0; i<n; i++) {
				if(Visit[i])
					System.out.print(D[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<n; i++) {
			Visit[i] = true;
			combi2(n, r-1, i+1);
			Visit[i] = false;
		}
	}

	public static void combi3(int n, int r, int start) {
		if (r == 0) {
			System.out.println(Arrays.toString(T));
			return;
		}
		for (int i=start; i<n; i++) {
			T[r-1] = D[i];
			combi3(n, r-1, i+1);
		}
	}

	public static void combi4(int r) {
		for (int mask=0; mask< (1<<D.length); mask++) {
			if (Integer.bitCount(mask) == r) {
				for (int pos=0; pos<D.length; pos++) {
					if ((mask & (1<<pos)) != 0) {
						System.out.print(D[pos] + " ");
					}
				}
				System.out.println();
			}
		}

	}

}
