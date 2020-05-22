package LeetCode.Easy;

public class ExcelSheetColumnNumber {
	class Solution {
	    public int titleToNumber(String s) {
	        int[] arr = new int[s.length()];

	        for(int i=0; i<s.length(); i++){
	            int n = s.charAt(i) - 64;
	            arr[i] = n;
	            if(i != 0){
	                for(int j=0; j<i; j++){
	                    arr[j] = arr[j] * 26;
	                }
	            }
	        }
	        
	        int result = 0;
	        for(int i : arr)
	            result += i;
	        return result;
	    }
	}
}
