package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class _1382BalanceaBinarySearchTree {

    public TreeNode balanceBST(TreeNode root) {

        if (root == null) {
            return null;
        }

        List<Integer> integers = new ArrayList<>();

        inorder(integers, root);

        return balanced(integers, 0, integers.size() - 1);

    }

    private void inorder(final List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
 // 1 2 3 4 5 6 7
    private TreeNode balanced(List<Integer> list, int low, int high) {

        if (low > high) {
            return null;
        }

        int midIndex = (low + high) / 2;

        int val = list.get(midIndex);

        // 0; -1
        TreeNode left = balanced(list, low, midIndex - 1);
        TreeNode right = balanced(list, midIndex + 1, high);

        //  2
        //1   3
        return new TreeNode(val, left, right);

    }
}
