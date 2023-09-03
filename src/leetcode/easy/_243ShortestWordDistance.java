package leetcode.easy;

public class _243ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2) {
        int firstIndex = -1;
        int secondIndex = -1;

        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                firstIndex = i;
            }
            if (word2.equals(words[i])) {
                secondIndex = i;
            }

        }
        return Math.abs(firstIndex - secondIndex);

    }
}
