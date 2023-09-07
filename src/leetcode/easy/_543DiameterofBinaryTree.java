package leetcode.easy;

public class _543DiameterofBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        int diameter[] = new int[1];
        int left = maxDepth(root.left, diameter);
        int right = maxDepth(root.right, diameter);

        return left + right + 1;
    }
//       1
//    2     3
//   4 5
/// 8    7//
// 6      8
    //     9
    private int maxDepth(TreeNode root, int[] diameter) {

        //begins with 0
        if (root == null){
            return 0;
        }

        final int left = maxDepth(root.left,diameter);
        final int right = maxDepth(root.right, diameter);

        diameter[0] = Math.max(diameter[0], left + right);

        if (left > right){
            return left + 1;
        } else {
            return right + 1;
        }

    }
}
