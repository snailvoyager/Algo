package im;

import java.util.Arrays;

public class PermutationInt {

	static int[] T;
	static boolean[] Visit = new boolean[5];
	static int[] D = {1,2,3,4,5};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int r = 3;
		
		T = new int[r];
		perm(n, r);
		System.out.println();
		perm2(n, r, 0);
	}

    public static void swap(int i, int j) {
        int temp = D[i];
        D[i] = D[j];
        D[j] = temp;
    }
    
    public static void perm(int n, int r){		//SWAP 방식
    	if(r == 0){
    		System.out.println(Arrays.toString(T));
    		return;
    	}
    	
    	for(int i=n-1; i>=0; i--){
    		swap(i, n-1);
    		T[r-1] = D[n-1];
    		perm(n-1, r-1);
    		swap(i, n-1);
    	}
    }
    
    public static void perm2(int n, int r, int depth) {		//Visited 방식
    	if(depth == r) {
    		System.out.println(Arrays.toString(T));
    		return;
    	}
    	
    	for(int i=0; i<n; i++) {
    		if(!Visit[i]) {
    			Visit[i] = true;
    			T[depth] = D[i];
    			perm2(n, r, depth+1);
    			Visit[i] = false;
    		}
    	}
    }
}
