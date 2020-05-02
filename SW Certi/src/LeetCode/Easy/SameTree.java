package LeetCode.Easy;

public class SameTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
	class Solution {
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	        if(p != null && q != null && p.val == q.val){
	            if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
	                return true;
	            else
	                return false;
	        } else if(p==null && q==null){
	                return true;
	        } else{
	            return false;
	        }
	        //return true;
	    }
	}

}

