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
	}
	
	public static void combi(int n, int r){			//재귀
		if(r == 0){
			System.out.println(Arrays.toString(T));
			return;
		} else if(n < r){
			return;
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

}
