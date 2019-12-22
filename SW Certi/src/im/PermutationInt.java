package im;

import java.util.Arrays;

public class PermutationInt {

	static int[] T;
	static int[] D = {1,2,3,4,5};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int r = 3;
		
		T = new int[r];
//		perm(arr, 0);
		perm2(n, r);
	}

/*	public static void perm(int[] arr, int pivot) {
        
        if (pivot == arr.length) { 
            System.out.println("#"+Arrays.toString(arr));
            return;
        }

        for (int i = pivot; i < arr.length; i++) {
            swap(arr, i, pivot);
            perm(arr, pivot + 1);
            swap(arr, i, pivot);
        }

    }*/

    public static void swap(int i, int j) {
        int temp = D[i];
        D[i] = D[j];
        D[j] = temp;
    }
    
    public static void perm2(int n, int r){
    	if(r == 0){
    		System.out.println(Arrays.toString(T));
    		return;
    	}
    	
    	for(int i=n-1; i>=0; i--){
    		swap(i, n-1);
    		T[r-1] = D[n-1];
    		perm2(n-1, r-1);
    		swap(i, n-1);
    	}
    }
}
