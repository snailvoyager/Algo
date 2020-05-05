package LeetCode.Easy;

public class MaximumDepth {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	class Solution {
	    public int maxDepth(TreeNode root) {
	        if(root != null)
	            return findDepth(root, 1);
	        else
	            return 0;
	    }
	    
	    public int findDepth(TreeNode node, int depth){
	        int left = 0;
	        int right = 0;
	        
	        if(node.left != null)
	            left = findDepth(node.left, depth+1);
	        if(node.right != null)
	            right = findDepth(node.right, depth+1);
	        
	        if(left == 0 && right == 0)
	            return depth;
	        else{
	            return left > right ? left : right;
	        }
	    }
	}
}
