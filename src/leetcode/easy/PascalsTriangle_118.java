package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

//Given an integer numRows, return the first numRows
// of Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of
// the two numbers directly above it as shown:
public class PascalsTriangle_118 {


    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascalTr = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                List<Integer> firstLine = new ArrayList<>();
                firstLine.add(1);
                pascalTr.add(firstLine);
            } else {
                List<Integer> prev = pascalTr.get(i - 2);
                List<Integer> list = new ArrayList<>();

                int i1 = prev.size() + 1;
                for (int j = 0; j < i1; j++) {
                    list.add(getInteger(prev, j - 1) + getInteger(prev, j));
                }

                pascalTr.add(list);
            }
        }

        return pascalTr;
    }

    private static Integer getInteger(final List<Integer> prev, final int j) {
        if (j < 0 || j >= prev.size()){
            return 0;
        }
        return prev.get(j);
    }

}
