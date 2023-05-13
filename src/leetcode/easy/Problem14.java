package leetcode.easy;

import java.util.Arrays;

import static java.util.Comparator.comparingInt;

//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
public class Problem14 {


    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, comparingInt(String::length));

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = getPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                return prefix;
            }
        }

        return prefix;
    }

    private static String getPrefix(String prefix, String word) {
        StringBuilder newPrefix = new StringBuilder();

        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) != word.charAt(i)) {
                break;
            }
            newPrefix.append(prefix.charAt(i));
        }

        return newPrefix.toString();
    }
}
