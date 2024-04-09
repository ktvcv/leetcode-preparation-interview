package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class _347TopKFrequentElements {


    class Bucket{

        int num;
        int occur;

        public Bucket(int num, int occur) {
            this.num = num;
            this.occur = occur;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getOccur() {
            return occur;
        }

        public void setOccur(int occur) {
            this.occur = occur;
        }

//        public void add(int elem){
//
//        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        if (nums.length == 0){
            return new int[0];
        }
        final PriorityQueue<Integer> queue = new PriorityQueue<>();
        final TreeMap<Integer, Integer> queue1 = new TreeMap();
        int ind = 1;

        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        Integer f = queue.poll();
        for (int i = 1; i < queue.size() && queue1.size() == k; i++) {
            Integer poll = queue.poll();
            if (f.equals(poll)){
                ind++;
            } else {
                queue1.put(ind, f);
                ind = 1;
            }
            f = poll;
        }

        return queue1
            .values()
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }


}
