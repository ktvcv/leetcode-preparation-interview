package leetcode.hard;

public class _4MedianofTwoSortedArraysHardTopics {

    public static void main(String[] args) {

        System.out.println(findMedianSortedArrays(new int[]{1,2,11,34}, new int[]{4,7,10}));
    }
    //1 2  3 4
    //1 7  4 5
    // 1 6 9  3 4 11
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {


        int m = nums1.length;
        int n = nums2.length;

        int[] res = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i != m && j != n){
            if (nums1[i] > nums2[j]) {
                res[k] = nums2[j];
                j++;
            } else {
                res[k] = nums1[i];
                i++;
            }
            k++;

        }

        while (i <= m - 1) {
            res[k++] = nums1[i++];
        }

        while (j <= n - 1) {
            res[k++] = nums2[j++];
        }

        // 1 2 4 7 11 34
        if ((m + n) % 2 == 0){
            int re = res[(m + n) / 2 - 1];
            int re1 = res[(m + n) / 2];
            return (double) (re + re1) /2;
        } else {
            return res[(m + n) / 2 ];
        }
    }
}
