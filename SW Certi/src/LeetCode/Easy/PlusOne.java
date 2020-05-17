package LeetCode.Easy;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9, 9, 9};
		System.out.println(Arrays.toString(plusOne(arr)));
	}
	
	public static int[] plusOne(int[] digits) {
        int n = digits.length;
        int last = digits[n-1];
        if(last != 9){
        	System.out.println(1);
            digits[n-1] = ++last;
            return digits;
        } else{
        	n--;
            digits[n] = 0;
            while(n>0){
                --n;
                if(digits[n] != 9){
                    digits[n] += 1;
                    System.out.println(2);
                    return digits;
                } else{
                    digits[n] = 0;
                }
            }
            int[] result = new int[(digits.length+1)];
            result[0] = 1;
            System.out.println(3);
            return result;
        }
            
    }
}
