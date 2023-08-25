package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class _217ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> counts = new HashMap<>();

        for (final int num : nums) {
            if (counts.containsKey(num)){
                return true;
            }
            counts.merge(num, 1, Integer::sum);
        }

        return false;
    }
}
