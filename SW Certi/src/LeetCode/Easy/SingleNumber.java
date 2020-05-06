package LeetCode.Easy;

public class SingleNumber {
	class Solution {
	    public int singleNumber(int[] nums) {
	        int cnt = 0;
	        for(int i=0; i<nums.length; i++){
	            cnt ^= nums[i];
	        }

	        return cnt;
	    }
	}
}
