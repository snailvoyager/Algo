package LeetCode.Medium;

public class DeepestLeavesSum {
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
    int deepestIdx = 0;
    int resultSum = 0;

    public int deepestLeavesSum(TreeNode root) {
        nextNode(root, 0);

        return resultSum;
    }

    public void nextNode(TreeNode node, int idx) {
        if (idx > deepestIdx) {
            deepestIdx++;
            resultSum = node.val;
        } else if (idx == deepestIdx) {
            resultSum += node.val;
        }

        if (node.left != null) {
            nextNode(node.left, idx+1);
        }
        if (node.right != null) {
            nextNode(node.right, idx+1);
        }

    }
}
