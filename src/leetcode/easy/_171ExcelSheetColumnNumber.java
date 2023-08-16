package leetcode.easy;

public class _171ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("AAA"));
    }
    public static int titleToNumber(String columnTitle) {

        final char[] chars = columnTitle.toCharArray();
        int res = 0;
        int base = 26;
        char a = 'A';
        for (int i = chars.length - 1; i >= 0; i--) {
            // A is 0 now, not 1
            int current = chars[i] - a + 1;
            res += Math.pow(base, chars.length - 1 - i) * current;
        }

        return res;
    }
}
