package leetcode.hard;

import java.util.Arrays;

public class _135Candy {

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,2,10,4,1,2}));
    }

    public static int candy(int[] ratings) {

        // 1 2 10 4 3 1
        // 1 2  3 1 1 1
        //4 3 2 1
        int res = 0;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++){
            if (ratings[i] > ratings[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]){
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }{

        }

        return (int) Arrays.stream(candies)
            .asLongStream()
            .sum();
    }

    private int prevIndex(int[] ratings, int i){
        if (i < 0){
            return Integer.MAX_VALUE;
        } else {
            return ratings[i];
        }
    }

    private int nextIndex(int[] ratings, int i){
        if (i >= ratings.length){
            return Integer.MAX_VALUE;
        } else {
            return ratings[i];
        }
    }
}
