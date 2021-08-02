package LeetCode.Easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class DiameterofBinaryTree {

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
        int n=0;
        public int diameterOfBinaryTree(TreeNode root) {
            searchDiameter(root);
            return n;

        }

        public int searchDiameter(TreeNode node) {
            if (node == null ) return 0;

            int left = searchDiameter(node.left);
            int right = searchDiameter(node.right);

            int sum = left + right;
            n = Math.max(n, sum);

            return Math.max(left, right) + 1;
        }
    }
}
