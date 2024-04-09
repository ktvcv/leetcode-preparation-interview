package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class _17LetterCombinationsofaPhone_Number {
//   static Map<Integer, Set<Character>> charactersByDigit = new HashMap<>();
//
//       static {
//           charactersByDigit.put(2, Set.of('a', 'b', 'c'));
//           charactersByDigit.put(3, Set.of('d', 'e', 'f'));
//           charactersByDigit.put(4, Set.of('g', 'h', 'i'));
//           charactersByDigit.put(5, Set.of('j', 'k', 'l'));
//           charactersByDigit.put(6, Set.of('m', 'n', 'o'));
//           charactersByDigit.put(7, Set.of('p', 'q', 'r', 's'));
//           charactersByDigit.put(8, Set.of('t', 'u', 'v'));
//           charactersByDigit.put(9, Set.of('w', 'x', 'y', 'z'));
//           charactersByDigit.put(-1, Set.of(' '));
//       }
//
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
//    public static List<String> letterCombinations(String digits) {
//
//           if (digits.isBlank()){
//               return new ArrayList<>();
//           }
//
//        int[] res = digits.chars()
//            .map(c -> c - 48)
//            .toArray();
//
//        int n = res.length;
//           int cur = 0;
//           int lastFinished = 1;
//           List<String> strings = new ArrayList<>();
//
//           while (true){
//
//               for (char ch : charactersByDigit.get(res[cur])){
//                   for (char ch1 : charactersByDigit.get(getchars(res, cur + 1))){
//                       String comb = ch + (Character.isLetter(ch1) ? String.valueOf(ch1) : "");
//                    strings.add(comb);
//                   }
//               }
//
//               cur++;
//               lastFinished++;
//
//               if (cur >= n - 1 && lastFinished >= n){
//                   break;
//               }
//
//           }
//
//           return strings;
//    }
//
//    private static int getchars(int[] res, int index){
//         if (index >= res.length){
//             return -1;
//         }
//
//         return res[index];
//    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();

        String[] phone_map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> output = new ArrayList<>();
        backtrack("", digits, phone_map, output);
        return output;
    }

    private static void backtrack(String combination, String next_digits, String[] phone_map, List<String> output) {
        System.out.println("rem digits " + next_digits);
        if (next_digits.isEmpty()) {
            System.out.println("adding " + combination);
            output.add(combination);
        } else {
            String letters = phone_map[next_digits.charAt(0) - '2'];
            System.out.println("letters " + letters);
            for (char letter : letters.toCharArray()) {
                System.out.println("letter in for " + letter);
                backtrack(combination + letter, next_digits.substring(1), phone_map, output);
            }
        }
    }
}
