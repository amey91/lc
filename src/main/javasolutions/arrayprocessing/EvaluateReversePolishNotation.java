package javasolutions.arrayprocessing;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    // https://leetcode.com/problems/evaluate-reverse-polish-notation/
// 150. Evaluate Reverse Polish Notation

// stack

    class Solution {

        // for every string in input,
        //      if it is a operation then pop top 2 values and perform the operation and push result back
        //      else push to stack (i.e. it is a number)
        // space = N for stack
        // time = N for each String in input
        public int evalRPN(String[] tokens) {
            if (tokens == null || tokens.length == 0) {
                return 0;
            }

            Stack<String> stack = new Stack<>();

            for (String s : tokens) {
                if (isOperation(s)) {
                    String num2 = stack.pop();
                    String num1 = stack.pop();
                    stack.add(performOperation(num1, num2, s));
                } else {
                    stack.add(s);
                }
            }
            return Integer.parseInt(stack.pop());
        }

        private boolean isOperation(String o) {
            return "+".equals(o) || "-".equals(o) || "/".equals(o) || "*".equals(o);
        }

        private String performOperation(String num1, String num2, String operation) {
            switch (operation) {
                case "+":
                    return String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
                case "-":
                    return String.valueOf(Integer.parseInt(num1) - Integer.parseInt(num2));

                case "/":
                    // todo handle zero
                    return String.valueOf(Integer.parseInt(num1) / Integer.parseInt(num2));

                case "*":
                    return String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2));

                default:
                    return "";
            }
        }
    }
}
