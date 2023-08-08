package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class _144BinaryTreePreorderTraversal {

    //Given the root of a binary tree,
    // return the preorder traversal of its nodes' values.
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> integers = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }
        preorderTraversal(integers, root);

        return integers;
    }

    public static void preorderTraversal(
        List<Integer> nodes,
        TreeNode root
    ) {
        if (root == null){
            return;
        }
        nodes.add(root.val);
        preorderTraversal(nodes, root.left);
        preorderTraversal(nodes, root.right);


    }
}
