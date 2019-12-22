package im;

import java.util.Arrays;

public class Combination {

	static int[] T;
	static int[] D = {1,2,3,4,5,6};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int r = 3;
		
		T = new int[r];
		combi(n,r);
	}
	
	public static void combi(int n, int r){
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

}
