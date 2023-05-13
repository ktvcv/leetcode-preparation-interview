package leetcode.easy;

//Given an integer array nums and an integer val, remove all occurrences
// of val in nums in-place. The order of the elements may be changed.
// Then return the number of elements in nums which are not equal to val.
//
//Consider the number of elements in nums which are not equal to val be k,
// to get accepted, you need to do the following things:
//
//Change the array nums such that the first k elements of nums contain
// the elements which are not equal to val.
// The remaining elements of nums are not important as well as the size of nums.
//Return k.

import java.util.Arrays;

public class Problem27 {


    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1, 1, 12, 3, 5, 6, 6, 6, 1}, 1));
    }
    // -1- 1 12 1 3 - 0
    // 12 -1- 1 1 3 - 1
    // 12 3 -1- 1 1 - 2

    public static int removeElement(int[] nums, int val) {

        if (nums.length == 0) {
            return 0;
        }

        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[counter] = nums[i];
                counter++;
            }

        }

     //   System.out.println(Arrays.toString(nums));
        return counter;
    }

}
