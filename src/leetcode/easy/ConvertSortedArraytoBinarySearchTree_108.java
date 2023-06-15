package leetcode.easy;

//Given an integer array nums where
// the elements are sorted in ascending order,
// convert it to a
//height-balanced
// binary search tree.

public class ConvertSortedArraytoBinarySearchTree_108 {

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8});
    }
    public static TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0) {
            return null;
        }
        TreeNode rootNode = getTreeNode(nums, 0, nums.length - 1);

        return rootNode;

    }

    private static TreeNode getTreeNode(final int[] nums, final int start, final int end) {
        if (start > end) {
            return null;
        }

        int middle = (start + end) / 2;
        int root = nums[middle];

        TreeNode rootNode = new TreeNode(root);

        rootNode.left = getTreeNode(nums, start, middle - 1);
        System.out.println(rootNode.left);
        rootNode.right = getTreeNode(nums, middle + 1, end);
        System.out.println(rootNode.right);


        return rootNode;
    }
}
