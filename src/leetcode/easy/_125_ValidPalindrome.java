package leetcode.easy;

public class _125_ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("              r       "));
    }
    public static boolean isPalindrome(String s) {

        int i = 0, j = s.length() - 1;

        while (j > i) {
            while (i != j ) {
                if (!Character.isLetterOrDigit(s.charAt(i))) {
                    i++;
                } else break;
            }

            while (i != j) {
                if (!Character.isLetterOrDigit(s.charAt(j))) {
                    j--;
                } else break;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;j--;
        }

        return true;
    }
}
