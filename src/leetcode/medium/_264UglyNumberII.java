package leetcode.medium;

//An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
//
//Given an integer n, return the nth ugly number.

import java.util.ArrayList;
import java.util.List;

// 2, 3, 5, 7, 11, 13, 17
public class _264UglyNumberII {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(11));
    }

    public static int nthUglyNumber(int n) {
//2 3 5
        List<Integer> factors = new ArrayList<>();
        factors.add(2);
        factors.add(3);
        factors.add(5);
        List<Integer> uglyNums = new ArrayList<>();
        //  uglyNums.add(0);
        /// System.out.println(uglyNums);
        uglyNums.add(0);
        uglyNums.add(1);
        uglyNums.add(2);
        uglyNums.add(3);
        uglyNums.add(4);
        uglyNums.add(5);
        uglyNums.add(6);
        uglyNums.add(8);
        uglyNums.add(9);
        uglyNums.add(10);
        uglyNums.add(12);

        //  System.out.println(uglyNums.size());

        if (n < 11) {
            return uglyNums.get(n);
        }

        for (int i = 3; i < uglyNums.size(); i++) {
            for (int j = 0; j < factors.size(); j++) {
                int y = uglyNums.get(i) * factors.get(j);
                if (!uglyNums.contains(y)) {
                    uglyNums.add(y);
                    if (uglyNums.size() == n+1){
                        return uglyNums.get(n);
                    }
                }
            }

        }


        return uglyNums.get(n);
    }
}
