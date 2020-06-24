package javasolutions.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/permutations-ii/
//        47. Permutations II

public class Permutations2 {
    class Solution {
        // backtracking
        // Space = N
        // Time = NPN/k! = N!/k! where N is total number of characters and k is total number of duplicates
        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums == null) {
                return new ArrayList<>();
            }

            Arrays.sort(nums); //  bring all duplicates together
            ArrayDeque<Integer> remaining = new ArrayDeque<>();
            for (int n : nums) {
                remaining.offerLast(n);
            }

            List<List<Integer>> result = new ArrayList<>();
            ArrayDeque<Integer> currentStack = new ArrayDeque<>();

            permute(result, remaining, currentStack);

            return result;
        }

        private void permute(List<List<Integer>> result, ArrayDeque<Integer> remaining, ArrayDeque<Integer> currentStack) {
            if (remaining.isEmpty()) {
                result.add(new ArrayList<>(currentStack));
                return;
            }

            // for each number in front of queue, generate all permutations for other numbers. When done, place current number to back of queue. Continue for all numbers in the remaining queue.
            for (int i = 0; i < remaining.size(); i++) {
                currentStack.offer(remaining.pollFirst());
                permute(result, remaining, currentStack);
                int curr = currentStack.pollLast();
                remaining.offerLast(curr);

                // poll remaining num and add to last of remining i.e. skip recursion for same number
                // e.g. when remaining is 1,1,2 we first rung for 1 and 1,2
                // in next iteration remaining becomes 1,2,1 and then if we call for 1 and 2,1 then we will be repeating subsequences for 1,2 and 2,1 calls.
                // We avoid this by calling recursively for a number and then skipping all the same numbers in this iteration
                while (i < remaining.size() && remaining.peekFirst() == curr) {
                    remaining.offerLast(remaining.pollFirst());
                    i++;
                }
            }
        }
    }
}
