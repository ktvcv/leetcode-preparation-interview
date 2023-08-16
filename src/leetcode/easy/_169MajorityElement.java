package leetcode.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _169MajorityElement {

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> occurs = new HashMap<>();

        for (final int num : nums) {
            if (occurs.containsKey(num)) {
                Integer u = occurs.get(num);
                u++;
                occurs.put(num, u);

            } else {
                occurs.put(num, 1);
            }

            if (occurs.get(num) > nums.length / 2)
                return num;
        }

        return occurs
            .entrySet()
            .stream()
            .sorted(Comparator.comparingInt(Map.Entry::getValue))
            .findFirst()
            .get()
            .getKey();


    }
}
