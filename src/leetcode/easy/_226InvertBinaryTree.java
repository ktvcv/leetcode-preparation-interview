package leetcode.easy;

import java.util.Objects;

public class _226InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null){
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.right);
        invertTree(root.left);

        return root;
    }

}
