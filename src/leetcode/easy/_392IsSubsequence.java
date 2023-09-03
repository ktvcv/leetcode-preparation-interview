package leetcode.easy;

public class _392IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdccc"));
    }
    public  static boolean isSubsequence(String s, String t) {

        if (s.length() > t.length()) {
            return false;
        }

        int start = 0;

        //s = "abc", t = "ahbgdc"
        for (int i = 0; i < t.length() && start < s.length(); i++) {
            if (s.charAt(start) == t.charAt(i)) {
                start++;
            }
        }

        return start == s.length();
    }
}
