package leetcode.easy;

//Given an integer rowIndex, return the rowIndexth
// (0-indexed) row of the Pascal's triangle.
//
//In Pascal's triangle, each number is the sum
// of the two numbers directly above it as shown:

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII_119 {

    public static void main(String[] args) {
        System.out.println(getRow(2));
    }

    public static List<Integer> getRow(int rowIndex) {
        // Initialize the row with 1s
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        // Calculate each element of the row based on the previous row
        for (int i = 0; i <= rowIndex; ++i) {
            row.add(1);
            // first two rows inits with 1
            for (int j = i - 1; j > 0; --j) {
                System.out.println(j);
                row.set(j, row.get(j) + row.get(j - 1));
            }
            System.out.println(row);

        }
        return row;
    }
}
