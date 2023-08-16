package leetcode.easy;

public class _168ExcelSheetColumnTitle {

    public static void main(String[] args) {
        System.out.println(convertToTitle(703));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        int alphabetLength = 26;
        char constant = 'A';

        if (columnNumber < 27) {
            return String.valueOf(((char) (constant + columnNumber)));
        }

        int v = (int) (Math.log(columnNumber - alphabetLength) / Math.log(alphabetLength));
        int n = v < 1
            ? v + 1
            : v;

        while (columnNumber-- > 0) {

            int left = columnNumber % alphabetLength;
            columnNumber = columnNumber / alphabetLength;
            stringBuilder.append(((char) (constant + left)));
        }

        return stringBuilder.reverse().toString();
    }
}
