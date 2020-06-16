package javalang.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Permutations {
//https://leetcode.com/problems/permutations/
//    46. Permutations
    class Solution {

        // use 1 queue and 1 stack.
        // Queue maintains remaining elements to be processed
        // Stack maintains prefix of the current result at any point
        // space = N for queue/stack + N for N! for recursion
        // time = N! since there are N! permutations
        // INTUITION consider 1234
        // first loop iterates over 1234 like 1234, 2341, 3412, 4123 (it then places 4 to back to queue at the end)
        // second loop iterates over 234
        // third loop iterates over 34
        // fourth loop iterates over 4
        public List<List<Integer>> permute(int[] nums) {

            if (nums == null) {
                return new ArrayList<>();
            }
            // stores final result
            List<List<Integer>> result = new ArrayList<>();

            // stores numbers which have not been counted towards the answer at any point
            ArrayDeque<Integer> remaining = new ArrayDeque<>();

            // stores the numbers bottoms up in the order in which they will appear in the result
            // Imagine this is the prefix of the permutation at any given point
            ArrayDeque<Integer> currStack = new ArrayDeque<>();

            for (int n : nums) {
                // in the beginning all numbers are remaining
                remaining.offer(n);
            }

            permute(result, remaining, currStack);

            return result;
        }

        private void permute(List<List<Integer>> result, ArrayDeque<Integer> remaining, ArrayDeque<Integer> currentStack) {

            if (remaining.isEmpty()) {
                result.add(new ArrayList<>(currentStack));
                return;
            }

            // This loop generates permutations of all remaining numbers.
            // For every remaining number, we pop it and generate permutations of left over numbers
            // Once we are done generating permutations, we add it back to the end of remaining
            // This prevents the number from being processed for a second time for same prefix.
            // We run the loop for the entire size of remaining numbers. What this achieves is that the
            // loop runs for each number as first number of the prefix
            // e.g. in a,b,c
            // first it runs with a  and b,c and
            // then it runs with b and c,a
            // then it runs with c and b,a
            for (int i = 0; i < remaining.size(); i++) {
                currentStack.add(remaining.pollFirst());
                permute(result, remaining, currentStack);
                remaining.offerLast(currentStack.pollLast());
            }
        }
    }
}
