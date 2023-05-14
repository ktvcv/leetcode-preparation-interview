package leetcode.easy;

//Given a sorted array of distinct integers and a target value,
// return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
//
//You must write an algorithm with O(log n) runtime complexity.

public class Problem35 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1}, 0));
    }

    // 1  2 3 4 5 6 7 8 9 10 11
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return start;
    }

}

