package LeetCode.Easy;

import java.util.Stack;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-1534236469));
	}
	
	public static int reverse(int x) {
		char[] chArr = Integer.toString(x).toCharArray();	//String으로 변환 후 char 배열에 저장
		
		Stack<Character> stack = new Stack<>();
		
		if(x >= 0) {
			for(int i=0; i<chArr.length; i++)
				stack.push(chArr[i]);
		} else {
			for(int i=1; i<chArr.length; i++)
				stack.push(chArr[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		if(Long.parseLong(sb.toString()) > Integer.MAX_VALUE || Long.parseLong(sb.toString()) < Integer.MIN_VALUE) {
			return 0;
		}
		
		int result = Integer.parseInt(sb.toString());
		if(x < 0)
			result *= -1;
		
		return result;
	}

}
