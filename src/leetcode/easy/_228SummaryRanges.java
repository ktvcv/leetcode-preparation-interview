package leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _228SummaryRanges {

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{-2147483648,-2147483647,2147483647}));
    }

    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0){
            return Collections.emptyList();
        }
        List<String> list = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!num.isEmpty()) {
                Integer integer = num.get(num.size() - 1);
                if (Math.abs(nums[i] - integer) > 1) {
                    if (num.size() == 1) {
                        list.add(String.valueOf(num.get(0)));
                    } else {
                        list.add(num.get(0) + "->" + integer);
                    }
                    num.clear();
                }
            }
            num.add(nums[i]);
        }
        if (num.size() == 1) {
            list.add(String.valueOf(num.get(0)));
        } else {
            list.add(num.get(0) + "->" + num.get(num.size() - 1));
        }

        return list;
    }
}
