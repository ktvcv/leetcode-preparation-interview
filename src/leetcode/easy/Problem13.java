package leetcode.easy;

//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//For example, 2 is written as II in Roman numeral, just two ones added together.
// 12 is written as XII, which is simply X + II.
// The number 27 is written as XXVII, which is XX + V + II.
//
//Roman numerals are usually written largest to smallest from left to right.
// However, the numeral for four is not IIII.
// Instead, the number four is written as IV.
// Because the one is before the five we subtract it making four.
// The same principle applies to the number nine, which is written as IX.
// There are six instances where subtraction is used:
//
//I can be placed before V (5) and X (10) to make 4 and 9.
//X can be placed before L (50) and C (100) to make 40 and 90.
//C can be placed before D (500) and M (1000) to make 400 and 900.
//Given a roman numeral, convert it to an integer.

import java.util.HashMap;
import java.util.Map;

public class Problem13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("XXX"));
    }

    public static final Map<Character, Integer> integerByRoman = new HashMap<>();

    //iiix = 7: 1 <= 1, 1 + 1, 2 + 1,  3 < 7, 7 - 3 = 4
    // the most left value is
    //xii = 12: 10 > 1, 10 > 2, 10 + 2 = 12
    static {
        integerByRoman.put('I', 1);
        integerByRoman.put('V', 5);
        integerByRoman.put('X', 10);
        integerByRoman.put('L', 50);
        integerByRoman.put('C', 100);
        integerByRoman.put('D', 500);
        integerByRoman.put('M', 1000);
    }


    public static int romanToInt(final String s) {

        final char[] chars = s.toCharArray();
        int res = 0;
        int[] nums = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            int currentNum = switch (chars[i]) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };
            ;
            nums[i] = currentNum;
            if (chars.length == 1) {
                return currentNum;
            } else if (i == 0) {

            } else {
                int prev = nums[i - 1];
                if ((i == chars.length - 1)) {
                    if (prev >= currentNum) {
                        res = res + prev + currentNum;
                    } else {
                        res = res - prev + currentNum;
                    }
                } else {
                    if (prev >= currentNum) {
                        res = res + prev;
                    } else {
                        res = res - prev;
                    }
                }
            }
        }

        return res;
    }
}
