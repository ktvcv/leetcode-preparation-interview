package leetcode.medium;

//quick select, quick sort
public class _215_KthLargestElementinanArray {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{1, 3, 2, 8, 9, 0, 3}, 4));
    }

    //1 2 3 4 5 6 7
    public static int findKthLargest(int[] nums, int k) {
        //smallest
        int indx = nums.length - k;

        return kthLargest(nums, 0, nums.length - 1, indx);
    }

    private static int partition(int[] nums, int left, int right) {
        int ans = nums[right], i = left;

        // what is index of right element
        for (int j = left; j < right; j++) {
            if (nums[j] <= ans) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        }
        //putting right element to his position
        int temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;

        return i;
    }

    public static int kthLargest(int[] arr, int l,
                                 int r, int k) {
        if (l == r) {
            return arr[l];
        }

        // Partition the array around last
        // element and get position of pivot
        // element in sorted array
        int pos = partition(arr, l, r);

        // If position is same as k
        if (pos == k)
            return arr[pos];

        // If position is more, recur for
        // left subarray
        if (pos > k)
            return kthLargest(arr, l, pos - 1, k);

        // Else recur for right subarray
        return kthLargest(arr, pos + 1, r, k);
    }
}

