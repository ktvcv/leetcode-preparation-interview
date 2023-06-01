package leetcode.easy;

public class Problem69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(0));
    }

    public static int mySqrt(int x) {

        double approx = 0.99;
        double accuracy = 0.01;
        double diff = x;

        while (diff > accuracy) {
            diff = Math.abs(approx * approx - x);
            double y = x / approx;
            approx = (approx + y) / 2;

        }

        return (int)(approx);
    }
}
