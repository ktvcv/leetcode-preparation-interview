package leetcode.easy;

//Given the root of a binary tree, return its maximum depth.
//
//A binary tree's maximum depth is the number
// of nodes along the longest path from the root node down
// to the farthest leaf node.

public class MaximumDepthOfBinaryTree_104 {

    public int maxDepth(TreeNode root) {

        //begins with 0
        if (root == null){
            return 0;
        }

        final int left = maxDepth(root.left);
        final int right = maxDepth(root.right);

        if (left > right){
            return left + 1;
        } else {
            return right + 1;
        }

    }

}
