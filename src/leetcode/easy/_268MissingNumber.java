package leetcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class _268MissingNumber {


    public static void main(String[] args) {

    }

    public static int missingNumber(int[] nums) {

//        Arrays.sort(nums);
//        //int u =
//
//        for (int i = 0; i < nums.length - 1; i++) {
//           if (Math.abs(nums[i] - nums[i+1]) > 1){
//               return nums[i] + 1;
//           }
//        }
//
//        return -1;
        int xor = 0;

        // x XOR x = 0
        for (final int num : nums) {
            xor ^= num;
        }

        for (int i = 0; i < nums.length; i++) {
            xor ^= i;
        }


        return xor;
    }
}
