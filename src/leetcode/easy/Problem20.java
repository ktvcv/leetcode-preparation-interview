package leetcode.easy;

//Given a string s containing just the characters
// '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem20 {

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {

        final Stack<Character> stackParentheses = new Stack<>();

        char[] chars = s.toCharArray();
        Map<Character, Character> parenthesesByOpposite = new HashMap<>();
        parenthesesByOpposite.put(']', '[');
        parenthesesByOpposite.put(')', '(');
        parenthesesByOpposite.put('}', '{');
        for (final Character symbol : chars) {
            if (symbol.equals('[') || symbol.equals('(') || symbol.equals('{')) {
                stackParentheses.push(symbol);

            } else {
                try {
                    if (stackParentheses.pop() != parenthesesByOpposite.get(symbol)) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }

        return stackParentheses.empty();
    }
}
