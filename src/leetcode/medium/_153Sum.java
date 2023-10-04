package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _153Sum {

    // -2 -1 0 3 1 1

    // -2 1 1

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        //nlogn
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;

            int k = nums.length - 1;

            while (j < k) {
                int res = nums[i] + nums[j] + nums[k];
                if (res == 0) {
                    list.add(List.of(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    //step ahead in any case
                    j++;
                    k--;
                } else if (res < 0) {
                    j++;
                } else k--;

            }

        }

        return list;
    }

    //        public static int findKthLargest(int[] nums, int k) {
    //         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    //        for(int i : nums){
    //            pq.add(i);
    //        }
    //        while(k > 1){
    //            pq.poll();
    //            --k;
    //        }
    //        return pq.poll();
    //    }
}
