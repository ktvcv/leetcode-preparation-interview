package leetcode.easy;

// 1 2 3 4 5 6 7 1 2 1
// k = 2

import java.util.HashMap;
import java.util.Map;

public class _219ContainsDuplicateII {

    //nums[i] == nums[j] and abs(i - j) <= k
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        final Map<Integer, Integer> indexByNumber = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (indexByNumber.containsKey(nums[i])){
                // 0 - 8 = 8
                // 1 -> 8
                // 8 - 10 = 2
                if (Math.abs(indexByNumber.get(nums[i]) - i) <= k){
                    return true;
                }
            }
            indexByNumber.put(nums[i], i);
        }

        return false;
    }

}
