package javalang;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    // 1249. Minimum Remove to Make Valid Parentheses
// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
    class Solution {
        class Node {
            Character c;
            int index;

            public Node(Character c, int index) {
                this.index = index;
                this.c = c;
            }
        }

        public String minRemoveToMakeValid(String s) {

            if (s == null || s.length() == 0) {
                return "";
            }

            char[] chars = s.toCharArray();

            Stack<Node> stack = new Stack<>();
            Set<Integer> indexes = new HashSet<>();

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') {
                    stack.push(new Node(chars[i], i));
                } else if (chars[i] == ')') {

                    //// OPTIMIZATION: can just make a note of the invalid indexes one way and then run the algorithm the opposite direction to identify useless (
                    // Thus, we eliminate the need for stack and can create the final result by simply omitting the invalid indexes from the hashset

                    if (!stack.empty() && stack.peek().c == '(') {
                        stack.pop();
                    } else {
                        stack.push(new Node(')', i));
                    }
                }
            }

            while (!stack.isEmpty() && stack.peek() != null) {
                indexes.add(stack.pop().index);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (indexes.contains(i)) {
                    // skip
                    indexes.remove(i);
                } else {
                    sb.append(chars[i]);
                }
            }
            return sb.toString();
        }

    }
}
