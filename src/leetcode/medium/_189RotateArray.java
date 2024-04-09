package leetcode.medium;

import java.util.Arrays;

public class _189RotateArray {

    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    // 5 10
    public static void rotate(int[] nums, int k) {

        k = k % nums.length;

        final int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int ind = findNewIndex(nums, k, i);
            temp[ind] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, nums.length);

    }

    static int  findNewIndex(int[] nums, int k, int index){
        int indx = k + index;// 3 + 3
        if (indx >= nums.length){
            return indx - nums.length;
        }

        return indx;
    }
}
