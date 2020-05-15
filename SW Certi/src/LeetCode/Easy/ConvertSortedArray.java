package LeetCode.Easy;

public class ConvertSortedArray {
	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	 
	class Solution {
	    public TreeNode sortedArrayToBST(int[] nums) {
	        if(nums.length == 0)
	            return null;
	        
	        TreeNode node = helper(nums, 0, nums.length-1);
	        return node;
	    }
	    
	    public TreeNode helper(int[] nums, int low, int high){
	        if(low > high)
	            return null;
	        int n = (low + high) / 2;
	        TreeNode node = new TreeNode(nums[n]);
	        node.left = helper(nums, low, n-1);
	        node.right= helper(nums, n+1, high);
	        return node;
	    }
	}
}
