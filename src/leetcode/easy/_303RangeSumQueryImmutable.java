package leetcode.easy;

public class _303RangeSumQueryImmutable {

    int[] numbers;

    public _303RangeSumQueryImmutable(int[] nums) {
        numbers = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                numbers[i] = nums[i];
            } else numbers[i] = numbers[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return numbers[right];
        }

        return numbers[right] - numbers[left - 1];
    }
}
