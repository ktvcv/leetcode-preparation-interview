package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class _242ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("ac", "ca"));
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != 0)
                return false;
        }
        return true;

//        int sCode = 0;
//        int tCode = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            sCode ^= s.charAt(i);
//        }
//
//        for (int i = 0; i < t.length(); i++) {
//            tCode ^= t.charAt(i);
//        }
//
//        return sCode == tCode;
    }
}
