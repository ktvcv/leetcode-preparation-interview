package leetcode.medium;

public class _238ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        int[] pref = new int[length];
        int[] suf = new int[length];

        pref[0] = 1;
        suf[length-1] = 1;

        for (int i = 1; i < length; i++){
            pref[i] = pref[i - 1] * nums[i - 1];
        }

        // 1  2   3   4
        // 1  1   2  6
        // 24 12  4  1
        for (int i = length - 2; i >= 0; i--){
            suf[i] = suf[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = suf[i] * pref[i];
        }

        return ans;
    }
}
