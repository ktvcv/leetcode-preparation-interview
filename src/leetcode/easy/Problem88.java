package leetcode.easy;

import java.util.Arrays;

public class Problem88 {

    //You are given two integer arrays nums1 and nums2,
    // sorted in non-decreasing order,
    // and two integers m and n, representing
    // the number of elements in nums1
    // and nums2 respectively.
    //
    //Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    //
    //The final sorted array should not be returned by the function,
    // but instead be stored inside the array nums1.
    // To accommodate this, nums1 has a length of m + n,
    // where the first m elements denote the elements that should be merged,
    // and the last n elements are set to 0 and should be ignored.
    // nums2 has a length of n.

    public static void main(String[] args) {
        int[] num1 = new int[]{0, 0, 0, 0};
        int[] num2 = new int[]{1, 2, 4, 4};
        merge(num1, 0, num2, 4);
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));

    }

    // 1 2 0 0
    // 2 7
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums2.length == 0 || nums1.length == 0){
            return;
        }

        int i = Math.max(m - 1, 0);
        int j = Math.max(n - 1, 0);
        int k = m + n - 1;

            while (i >= 0 && j >= 0) {
                if (nums1[i] < nums2[j]) {
                    nums1[k] = nums2[j];
                    j--;
                } else {
                    nums1[k] = nums1[i];
                    i--;
                }
                k--;
            }
            while (j >= 0){
                nums1[k] = nums2[j];
                j--;
                k--;
            }
    }
}