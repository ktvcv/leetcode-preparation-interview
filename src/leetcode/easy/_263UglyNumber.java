package leetcode.easy;

public class _263UglyNumber {

    public boolean isUgly(int n) {

        if (n <= 0) return false;
        for (int i = 2; i < 6 && n > 0; i++) {
            // 20 10 5
            while (n % i == 0) {
                n /= i;
            }
        }
        return n == 1;

    }
}
