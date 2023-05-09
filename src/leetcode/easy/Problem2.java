package leetcode.easy;

public class Problem2 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(101001));
    }
    // Given an integer x, return true if x is a
    //palindrome
    // and false otherwise.
    public static boolean isPalindrome(final int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        final char[] chars = String.valueOf(x).toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }

        return true;
    }
}
