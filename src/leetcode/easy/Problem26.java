package leetcode.easy;

//Given an integer array nums sorted in non-decreasing order,
// remove the duplicates in-place such that each unique element appears only once.
// The relative order of the elements should be kept the same.
// Then return the number of unique elements in nums.
//
//Consider the number of unique elements of nums to be k,
// to get accepted, you need to do the following things:
//
//Change the array nums such that the first
// k elements of nums contain the unique elements in the order they
// were present in nums initially. The remaining elements of nums are
// not important as well as the size of nums.
//Return k.


public class Problem26 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 0, 1, 1, 1, 3}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int counter = 1;
        int lastNumber = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastNumber) {
                nums[counter] = nums[i];
                counter++;
                lastNumber = nums[i];
            }
        }

        return counter;
    }
}
