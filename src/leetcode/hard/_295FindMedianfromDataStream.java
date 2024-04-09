package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _295FindMedianfromDataStream {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(6);
//        medianFinder.addNum(19);
//        medianFinder.addNum(3);
//        medianFinder.addNum(7);
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        medianFinder.addNum(-3);

        System.out.println(medianFinder.findMedian());
    }
}

class MedianFinder {
    private final PriorityQueue<Integer> lowQueue = new PriorityQueue<>(
        (o1, o2) -> {
            Integer o1Unsigned = Math.abs(o1);
            Integer o2Unsigned = Math.abs(o2);

            return -1 * Integer.compare(o1Unsigned, o2Unsigned);
        });
    //to store element in reverse order to poll the lowest first
    //to store the median in case it is uneven number of elements
    private final PriorityQueue<Integer> highQueue = new PriorityQueue<>(
        (o1, o2) -> {
            Integer o1Unsigned = Math.abs(o1);
            Integer o2Unsigned = Math.abs(o2);

            return Integer.compare(o1Unsigned, o2Unsigned);
        });
    public MedianFinder() {

    }

    public void addNum(int num) {
        highQueue.offer(num);

        if (highQueue.size() - lowQueue.size() > 1
            || (highQueue.size() + lowQueue.size()) % 2 == 0){
            // if (lowQueue.size() > 0 && lowQueue.peek() < highQueue.peek())
                lowQueue.offer(highQueue.poll());
           // else if (lowQueue.size() > 0 && lowQueue.peek() > highQueue.peek())

        } else {
            if (!lowQueue.isEmpty() && Math.abs(lowQueue.peek()) > Math.abs(highQueue.peek())){
                Integer pull = highQueue.poll();
                highQueue.offer(lowQueue.poll());
                lowQueue.offer(pull);
            }
        }
    }

    public double findMedian() {
        if ((highQueue.size() + lowQueue.size()) % 2 == 0){
            return (highQueue.peek() + lowQueue.peek()) / 2.00;
        } else {
            return highQueue.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
