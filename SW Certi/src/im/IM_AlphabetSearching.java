package im;

import java.util.Scanner;

public class IM_AlphabetSearching {

	static int Answer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++){
			
			System.out.println(factorial(8));
			
			System.out.println("#"+test_case+" "+Answer);
		}
	}
	
	public static long factorial(long n){
		if(n<=0) return 0;
		if(n==1) return 1;
		
		return n * factorial(n-1);
	}
	

}


/*
5
abcdefgh
abcdefhg
abcdegfh
fbhacdeg
hgfedcba

#1 1
#2 2
#3 3
#4 26521 
#5 40320 
 */
