package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class _290WordPattern {
    // abba - cat dog dog cat
    public boolean wordPattern(String pattern, String s) {

        String[] strings = s.split(" ");
        char[] chars = pattern.toCharArray();

        if (strings.length != chars.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (charToWord.containsKey(chars[i])) {
                if (!charToWord.get(chars[i]).equals(strings[i])) {
                    return false;
                }
            } else {
                charToWord.put(chars[i], strings[i]);
            }
        }


        return true;
    }
}

//static public List<String> getHashtags(List<String> twits) {
//        return twits.stream().flatMap(s -> Arrays.stream(s.split(" "))).filter(s -> s.startsWith("#"))
//                .map(s -> s = s.replace("#", ""))
//                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
//                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(Map.Entry::getKey).collect(Collectors.toList());
