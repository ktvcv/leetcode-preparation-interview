package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1 {

    public static void main(String[] args) {
        final int[] sample1 = new int[]{3, 2, 4};
        System.out.println(Arrays.toString(twoSum(sample1, 6)));
    }
//    Given an array of integers nums and an integer target, return indices of the
//    two numbers such that they add up to target.
//    You may assume that each input would have exactly one solution,
//    and you may not use the same element twice.
//    You can return the answer in any order.

    public static int[] twoSum(final int[] nums, final int target) {

        final Map<Integer, Integer> elementByIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            elementByIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            final Integer possibleIndexElement2 = elementByIndex.get(target - nums[i]);

            if (possibleIndexElement2 != null && i != possibleIndexElement2) {
                return new int[]{i, possibleIndexElement2};
            }
        }

        return new int[]{};
    }

}
