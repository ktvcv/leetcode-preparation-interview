package leetcode.easy;

public class _222CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {

        //begins with 0
        if (root == null) {
            return 0;
        }

        final int left = countNodes(root.left);
        final int right = countNodes(root.right);

        // 1 is a parent
        // left/right is parent for other left/right, so we add 1 as parent one
        return left + right + 1;
    }
}
