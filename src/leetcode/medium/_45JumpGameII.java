package leetcode.medium;

public class _45JumpGameII {
    public int jump(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }
        int steps = 0;
        int reach = 0;   // Initilize variable reach as 0, to store reach of the highest index.
        for (int i = 0; i < nums.length; i++) {

            if (i + nums[i] > reach) {
                reach = i + nums[i];
                steps++;
                if (reach == nums.length - 1){
                    return steps;
                }

            }


        }

        return steps;
    }
}
