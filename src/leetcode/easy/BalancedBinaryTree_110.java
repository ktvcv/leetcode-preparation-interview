package leetcode.easy;

//Given a binary tree, determine if it is
//height-balanced

public class BalancedBinaryTree_110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return false;
        }
        return maxDepth(root) != -1;

    }

    public int maxDepth(TreeNode root) {

        //begins with 0
        if (root == null){
            return 0;
        }

        //check left subtree
        final int left = maxDepth(root.left);
        if (left == -1){
            return -1;
        }
        //check right subtree
        final int right = maxDepth(root.right);
        if (right == -1){
            return -1;
        }

        if (Math.abs(left - right) > 1){
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
