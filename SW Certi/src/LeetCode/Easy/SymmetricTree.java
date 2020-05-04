package LeetCode.Easy;

public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	class Solution {
	    public boolean isSymmetric(TreeNode root) {
	    	return root==null || isSymmetricSub(root.left, root.right);
	    }
	    
	    public boolean isSymmetricSub(TreeNode left, TreeNode right) {
	    	if(left == null || right == null) {
	    		return left == right;
	    	} else if(left.val != right.val) {
	    		return false;
	    	} else {
	    		return isSymmetricSub(left.left, right.right) && isSymmetricSub(left.right, right.left); 
	    	}
	    }
	}

}
