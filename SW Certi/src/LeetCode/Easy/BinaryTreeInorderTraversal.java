package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            traversal(root, list);
            return list;
        }

        public void traversal(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }

            traversal(node.left, list);
            list.add(node.val);
            traversal(node.right, list);
        }
    }
}
