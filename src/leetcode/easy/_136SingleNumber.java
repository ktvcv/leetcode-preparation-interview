package leetcode.easy;

public class _136SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[2]));
    }

    public static int singleNumber(int[] nums) {

        int i = 0;
        for (final int num : nums) {
            i = i ^ num;
        }

        return i;
    }
}
