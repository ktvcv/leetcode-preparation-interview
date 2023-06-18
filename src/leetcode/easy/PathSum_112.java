package leetcode.easy;

//Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
//
//A leaf is a node with no children.
public class PathSum_112 {

    // not passing
    public boolean hasPathSum(TreeNode root, int targetSum) {

       // boolean ans = false;
        if (root == null){
            return false;
        }
        int sum = targetSum - root.val;
        if (sum == 0 && root.left == null
            && root.right == null
        ) {
            return true;
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

}
