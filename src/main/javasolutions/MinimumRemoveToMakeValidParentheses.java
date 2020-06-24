package javasolutions;

public class MinimumRemoveToMakeValidParentheses {
    // 1249. Minimum Remove to Make Valid Parentheses
// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

// space = N
// time = N

    // we parse both directions and for each directions, we make a note of the unbalanced parentheses and in third pass we delete those
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

            boolean[] excluded = passParenthesesToFindInvalidIndexes(chars);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (excluded[i]) {
                    // skip
                    continue;
                } else {
                    sb.append(chars[i]);
                }
            }
            return sb.toString();
        }

        private boolean[] passParenthesesToFindInvalidIndexes(char[] chars) {

            boolean[] excludeIndex = new boolean[chars.length];
            int balance = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') {
                    balance++;
                } else if (chars[i] == ')') {
                    if (balance == 0) {

                        // no balancing parentheses
                        excludeIndex[i] = true;
                    } else {
                        balance--;
                    }
                }
            }

            balance = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] == ')') {
                    balance++;
                } else if (chars[i] == '(') {
                    if (balance == 0) {

                        // no balancing parentheses
                        excludeIndex[i] = true;
                    } else {
                        balance--;
                    }
                }
            }

            return excludeIndex;
        }

    }
}
