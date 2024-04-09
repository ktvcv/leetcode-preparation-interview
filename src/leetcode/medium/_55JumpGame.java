package leetcode.medium;

public class _55JumpGame {

    public boolean canJump(int[] nums) {

        if (nums.length == 0){
            return false;
        }
        if (nums.length == 1){
            return true;
        }
        int reach = 0;   // Initilize variable reach as 0, to store reach of the highest index.
        for (int i = 0; i < nums.length; i++) {   // Iterate the nums and check if reach is smaller than i then return false else overwrite reach with max of reach and i+nums[i].
            if (reach < i) {
                return false;
            }
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }
}
