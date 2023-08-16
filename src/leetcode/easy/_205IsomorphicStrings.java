package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class _205IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "title"));
    }

    //Given two strings s and t, determine if they are isomorphic.
    //
    //Two strings s and t are isomorphic if the characters in s can be replaced to get t.
    public static boolean isIsomorphic(String s, String t) {

        Map<Character, Character> exchangeMap = new HashMap<>();
        Map<Character, Character> exchangeMapRev = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            if (
                (exchangeMap.get(s.charAt(i)) != null
                    && !Objects.equals(exchangeMap.get(s.charAt(i)), t.charAt(i)))
                    || (exchangeMapRev.get(t.charAt(i)) != null
                    && !Objects.equals(exchangeMap.get(s.charAt(i)), t.charAt(i)))
            ) {
                return false;
            }
            exchangeMap.put(s.charAt(i), t.charAt(i));
            exchangeMapRev.put(t.charAt(i), s.charAt(i));
        }

        return true;
    }
}
