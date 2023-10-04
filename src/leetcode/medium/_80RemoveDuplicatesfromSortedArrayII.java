package leetcode.medium;

public class _80RemoveDuplicatesfromSortedArrayII {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
    //Given an integer array nums sorted in non-decreasing order,
// remove some duplicates in-place such that each unique
// element appears at most twice.
// The relative order of the elements should be kept the same.
    public static int removeDuplicates(int[] nums) {
        // 1 1 1 1 2 2 2 3 3 3
        // 1 1 2 1 2 2

        if (nums.length < 3) {
            return nums.length;
        }
        int lastUniqueIndex = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[lastUniqueIndex - 2]) {
                nums[lastUniqueIndex] = nums[i];
                lastUniqueIndex++;
            }
        }

        return lastUniqueIndex;
    }

}
