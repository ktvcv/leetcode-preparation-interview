package leetcode.easy;

import java.util.Arrays;

public class Problem67 {

    public static void main(String[] args) {

        System.out.println(addBinary("111", "1001"));
    }

    public static String addBinary(String a, String b) {
        int max = Math.max(a.length(), b.length());
        char[] aC = new char[max];
        char[] bC = new char[max];
        Arrays.fill(aC, '0');
        Arrays.fill(bC, '0');

        for (int i = 0; i < a.length(); i++) {
            aC[i] = a.charAt(a.length() - i - 1);
        }
        for (int i = 0; i < b.length(); i++) {
            bC[i] = b.charAt(b.length() - i - 1);
        }

        int carry = 0;
        StringBuilder fin = new StringBuilder();
        for (int i = 0; i <= max - 1; i++) {
            int n1 = Integer.parseInt(String.valueOf(aC[i]));
            int n2 = Integer.parseInt(String.valueOf(bC[i]));

            if (n1 + n2 + carry == 2) {
                carry = 1;
                fin.append("0");
            } else if (n1 + n2 + carry == 3) {
                carry = 1;
                fin.append("1");
            } else if (n1 + n2 + carry == 1) {
                carry = 0;
                fin.append("1");
            } else {
                fin.append("0");
            }

        }

        if (carry == 1) {
            fin.append("1");
        }

        return fin.reverse().toString();
    }
}
