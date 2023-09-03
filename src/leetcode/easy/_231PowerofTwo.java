package leetcode.easy;

public class _231PowerofTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(32));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }

        /// 1000
        /// 0111
        /// 0000
}
