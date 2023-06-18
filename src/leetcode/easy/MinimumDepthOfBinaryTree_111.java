package leetcode.easy;

//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
//Note: A leaf is a node with no children.
public class MinimumDepthOfBinaryTree_111 {

    public int minDepth(TreeNode root) {

        //begins with 0
        if (root == null){
            return 0;
        }

        final int left = minDepth(root.left);
        final int right = minDepth(root.right);

        if (left == 0 && left < right){
            return right + 1;
        } else if (right == 0 && right < left){
            return left + 1;
        } else {
            return left > right
                ? right + 1
                : left + 1;
        }

    }

}

