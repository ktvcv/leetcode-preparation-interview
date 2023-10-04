package leetcode.easy;

public class _338CountingBits {

    public int[] countBits(int n) {

        int[] count  = new int[n+1];

        // 4 - 1 one, 8 - one, 3 - 2, 5 - 2, 6, - 2, 7 - 3
        //so if n  even - n/2 + else n/2
        for (int i = 1; i <= n; i++) {
            count[i] = count[i/2] + i%2;
        }

        return count;
    }
}
