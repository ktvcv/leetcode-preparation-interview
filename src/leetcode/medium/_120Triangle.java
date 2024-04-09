package leetcode.medium;

import java.util.List;

public class _120Triangle {

    //  1
    // 2 3
    //5 6 7

    // 8 9 10
    // 7 8 9
    // 5 6 7
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[][] sums = new int[n][n];

        //button row initialized
        for (int i = 0; i < n; i++) {
            sums[n-1][i] = triangle.get(n-1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++){
                sums[i][j] = Math.min(
                    sums[i+1][j] + triangle.get(i).get(j),
                    sums[i+1][j+1] + triangle.get(i).get(j)
                );
            }
        }

        return sums[0][0];

    }
}
