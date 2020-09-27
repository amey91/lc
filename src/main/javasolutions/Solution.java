package javasolutions;

import java.util.PriorityQueue;
import java.util.Stack;
class Solution {

    public static void main(String[] args) {
        System.out.println(checkValidString("(*))"));
    }

    public static boolean checkValidString(String s) {
        if (s == null) return false;

        if ("".equals(s.trim())) return true;
        Stack<Character> stack = new Stack<>();
        return checkString(s, 0, stack);
    }

    private static boolean checkString(String s, int index, Stack<Character> stack) {

        if (index == s.length()) {
            return stack.isEmpty();
        }

        Character curr = s.charAt(index);

        switch(curr) {
            case '*':
                // ignore
                if (checkString(s, index + 1, stack)) return true;

                stack.add('(');
                if (caseOpenBracket(s, index, stack)) return false;
                stack.pop();

                stack.add(')');
                if (caseCloseBracket(s, index, stack)) return true;
                stack.pop();
                return false;

            case '(':
                return caseOpenBracket(s, index, stack);

            case ')':
                return caseCloseBracket(s, index, stack);

        }

        return false;
    }

    private static boolean caseOpenBracket(String s, int index, Stack<Character> stack) {
        stack.add('(');
        return checkString(s, index + 1, stack);
    }

    private static boolean caseCloseBracket(String s, int index, Stack<Character> stack) {
        if (stack.isEmpty() || stack.peek() != '(') return false;
        stack.pop();
        return checkString(s, index + 1, stack);
    }
}