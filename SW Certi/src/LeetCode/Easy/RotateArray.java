package LeetCode.Easy;

public class RotateArray {

	class Solution {
	    public void rotate(int[] nums, int k) {
	        if(k == 0) return;
	        
	        int[] nums2 = new int[nums.length];
	        for(int i=0; i<nums.length; i++)
	            nums2[i] = nums[i];
	        
	        for(int i=0; i<nums.length; i++){
	            int n = i + k;
	            if(n >= nums.length){
	                n = n % nums.length;
	            }
	            nums[n] = nums2[i];
	        }
	    }
	}

}
