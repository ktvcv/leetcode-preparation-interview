package leetcode.easy;

import java.util.Arrays;

public class _283MoveZeroes {

    public static void main(String[] args) {
        moveZeroes(new int[]{1,1,0});
    }

    //Input: nums = [1,6,7,8,0]
    ////////////////[1,0,0,3,12]
    ////////////////[1,3,0,0,12]
    ////////////////[1,3,12,0,0]
    //Output: [1,3,12,0,0]
    public static void moveZeroes(int[] nums) {
        int numIndex;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numIndex = i + 1;
                while (numIndex < nums.length) {
                    if (nums[numIndex] == 0) {
                        numIndex++;
                    } else {
                        int temp = nums[numIndex];
                        nums[i] = temp;
                        nums[numIndex] = 0;
                        break;
                    }
                }
                if (numIndex == nums.length){
                    break;
                }

            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
