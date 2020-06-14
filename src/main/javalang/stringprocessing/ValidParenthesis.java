package javalang.stringprocessing;

import java.util.Stack;

public class ValidParenthesis {
    // 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/

    class Solution {

        // maintain stack of brackets
        public boolean isValid(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }

            Stack<Character> stack = new Stack<>();

            // IMPORTANT: forgot to check stack.isEMpty() before peek()
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '{' || c == '[' || c == '(') {
                    stack.push(c);
                } else if (c == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }
    }
}