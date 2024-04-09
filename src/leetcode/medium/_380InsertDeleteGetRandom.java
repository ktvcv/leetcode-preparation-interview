package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class _380InsertDeleteGetRandom {
}

class RandomizedSet {

    private final Random r = new Random();
    HashMap<Integer, Integer> nums;
    int[] numberdByIndex;

    int i;

    public RandomizedSet() {
        nums = new HashMap<>();
        numberdByIndex = new int[32];
        i = 0;
    }

    public boolean insert(int val) {
        if (nums.containsKey(val)) {
            return false;
        } else {
            if (nums.size() == numberdByIndex.length) {
                numberdByIndex = Arrays.copyOf(numberdByIndex, numberdByIndex.length * 2);
            }
            nums.put(val, i);
            numberdByIndex[i++] = val;

        }
            return true;
    }

    public boolean remove(int val) {
        Integer removed = nums.remove(val);
        if (removed == null) return false;

        if (removed < i - 1) {
            numberdByIndex[removed] = numberdByIndex[i-1];
            nums.put(numberdByIndex[i-1], removed);
        }
        i--;
        return true;
    }

    public int getRandom() {
        return r.nextInt(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
