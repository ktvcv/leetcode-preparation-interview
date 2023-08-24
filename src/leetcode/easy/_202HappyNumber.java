package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class _202HappyNumber {

    public static void main(String[] args) {
        isHappy(19);
    }

    public static boolean isHappy(int n) {
        final Set<Integer> saved = new HashSet<>();
        int res = 0;
        while (n != 1 || saved.contains(res)) {
            saved.add(res);
            while (n > 0) {
                int j = n % 10;
                res += Math.pow(j, 2);
                n = n / 10;
            }
            n = res;
        }
        return res == 1;
    }
}
