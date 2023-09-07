package leetcode.medium;

public class _33SearchinRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    }
    //[4,5,6,7 - sorted
    // 0,1,2].- sorted
    public static int search(int[] nums, int target) {

        // if nums rotated
        int st = 0;
        int end = nums.length - 1;
        int piv = nums.length - 1;
        while (st < end) {
            int pivot = st + (end-st) / 2;
            int n = nums[pivot];
            if (n > nums[pivot + 1]) {
                piv = pivot;
                break;
                // left sorted
            } else if (n > nums[0]) {
                st = pivot + 1;
            } else {
                end = pivot;
            }
        }
        int ind = find(nums, target, 0, piv);

        if (ind == -1){
            ind = find(nums, target, piv+1, nums.length - 1);
        }

        return ind;
    }

    private static int find(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int pivot = start + (end-start) / 2;
            int n = nums[pivot];
            if (n == target) {
                return pivot;
                // left sorted
            } else if (target > n) {
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
        }
        return -1;
    }
}
