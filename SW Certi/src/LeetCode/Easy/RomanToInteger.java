package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));
	}
	
	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int[] arr = new int[s.length()];
		
		for(int i=0; i<s.length(); i++) {
			if(map.containsKey(s.charAt(i)))
				arr[i] = map.get(s.charAt(i));
		}
		
		int result = arr[s.length()-1];		//마지막값 저장
		
		for(int i=s.length()-2; i>-1; i--) {
			if(arr[i] >= arr[i+1])
				result += arr[i];
			else
				result -= arr[i];
		}
		
		return result;
	}

}
