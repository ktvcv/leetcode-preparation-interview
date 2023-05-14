package leetcode.easy;

//Given two strings needle and haystack, return the
// index of the first occurrence of needle in haystack,
// or -1 if needle is not part of haystack

public class Problem28 {

    public static void main(String[] args) {

        System.out.println(strStr("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {

        if (haystack.isEmpty() || needle.isEmpty()) {
            return 0;
        }
        int counter = 0;
        int beginningPrefixIndex = -1;

        // to save potential new beginning index to reduce time complexity
        // to check also suffix
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(counter)) {
                if (counter == 0) {
                    beginningPrefixIndex = i;
                }
                counter++;
                if (counter == needle.length()) {
                    return beginningPrefixIndex;
                }
            } else {
                if (counter > 0) {
                    i = i - counter;
                }
                counter = 0;
                beginningPrefixIndex = -1;
            }
        }

        return -1;
    }

}
