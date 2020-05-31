package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	class Solution {
	    public boolean isHappy(int n) {
	        Set<Integer> set = new HashSet<>();
	        
	        while(set.add(n)){
	            int squares = 0;
	            while(n > 0){
	                squares += (n%10) * (n%10);
	                n /= 10;
	            }
	            if(squares == 1)
	                return true;
	            else
	                n = squares;
	        }
	        
	        return false;
	    }
	}
}
