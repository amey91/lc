package javasolutions.greedy;

import java.util.ArrayDeque;

public class ValidateStackSequences {

    // 946. Validate Stack Sequences
// https://leetcode.com/problems/validate-stack-sequences/

    class Solution {

        // Greedy approach of popping as many elements as possible at every stage
        // Keep index of where the pushed and popped indexes are at every point.
        // time = N + M
        // space = N
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            int popIndex = 0;
            for (int i = 0; i < pushed.length; i++) { // 0

                stack.offerLast(pushed[i]); //

                // pop all viable numbers
                while (!stack.isEmpty() && popIndex <
                        popped.length &&
                        stack.peekLast() == popped[popIndex]) {
                    stack.pollLast();
                    popIndex++;
                }
            }

            // check both elements were processed successfully
            return stack.isEmpty() && popIndex == popped.length;
        }
    }
}
