package leetcode.easy;

import java.util.Arrays;

//You are given a large integer represented as
// an integer array digits, where each digits[i]
// is the ith digit of the integer.
// The digits are ordered from most significant
// to least significant in left-to-right order.
// The large integer does not contain any leading 0's.
//
//Increment the large integer by one and return the resulting array of digits.
public class Problem66 {
//1 2 3 = 1*10^2 + 2 * 10 + 1

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{ 9})));
    }

    // 1 9 9 9 9 9 9
    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                Arrays.fill(digits, i + 1, digits.length, 0);
                break;
            } else if (digits[i] == 9 && i == 0) {
                digits = new int[digits.length + 1];
                Arrays.fill(digits, 0);
                digits[0] = 1;
            }

        }

        return digits;
    }

}
