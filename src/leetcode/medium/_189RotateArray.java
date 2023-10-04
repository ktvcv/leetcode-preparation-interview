package leetcode.medium;

public class _189RotateArray {

    public static void main(String[] args) {
        rotate(new int[]{-1, -100, 3, 99}, 2);
    }

    public static void rotate(int[] nums, int k) {

        // if current < k current + k
        // else current = current + k - length
        if (k == 0) {
            return;
        }

        if (k == nums.length / 2 && nums.length % 2 == 0) {
            for (int i = 0; i < nums.length / 2; i++) {
                int y = i + k;
                int t = nums[i];
                nums[i] = nums[y];
                nums[y] = t;

            }
            return;
        }

        int previos = nums[0];
        int current = 0;
        int next;

        int operations = 0;
        while (operations != nums.length) {
            next = current + k < nums.length ? current + k : current + k - nums.length;
            int t1 = nums[next];
            nums[next] = previos;
            previos = t1;
            operations++;
            current = next;
        }
    }
}
