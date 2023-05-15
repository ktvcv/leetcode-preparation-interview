package leetcode.easy;

//Given a string s consisting of words and spaces,
// return the length of the last word in the string.
//
//A word is a maximal substring consisting of non-space characters only.
public class Problem58 {


    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("aa a a a a aaa aaaa a aa aaaaaa "));
    }

    public static int lengthOfLastWord(String s) {

        int counter = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                counter++;
            } else {
                if (counter > 0) {
                    return counter;
                }
            }
        }
        return counter;
    }

}

