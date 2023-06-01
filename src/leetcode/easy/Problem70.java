package leetcode.easy;

public class Problem70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }

    public static int climbStairs(int n) {
        if (n < 2) {
            return n;
        }

        int[] ans = new int[n];
        ans[0] = 1;
        ans[1] = 2;
// Fibonacci principle
//try n = 4
//
//Same as above, we only have two choices (one step or two steps) at first
//
//one step ➔ three steps left Fn(3) = 3
// (the answer we have just gotten above)
//two steps ➔ two steps left Fn(2) = 2
//So, we can get the answer of Fn(4) = Fn(3)+Fn(2) = 3+2 = 5
        for (int i = 2; i < n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[n - 1];
    }
}

