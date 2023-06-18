package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Inorder_Traversal_94 {
//Given the root of a binary tree, return
// the inorder traversal of its nodes' values.

    public List<Integer> inorderTraversal(TreeNode root) {

        final List<Integer> integers = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        addInorder(root, integers);

        return integers;
    }

    void addInorder(TreeNode node, List<Integer> integers) {
        if (node == null)
            return;

        addInorder(node.left, integers);

        integers.add(node.val);

        // Now recur on right child
        addInorder(node.right, integers);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
            "val=" + val +
            '}';
    }
}
