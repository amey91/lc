package javalang.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSetsPowerSet {
    // 78. Subsets
// https://leetcode.com/problems/subsets/
// Power set!
    class Solution {

        // each element is either included or not included. Do backtracking
        // time = 2^N
        // space = N for maintaining current state  + 2^N result size
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            List<Integer> curr = new ArrayList<>();

            powerSet(nums, curr, result, 0);

            return result;
        }

        private void powerSet(int[] nums, List<Integer> current, List<List<Integer>> result, int index) {

            if (index == nums.length) {
                result.add(new ArrayList<>(current));
                return;
            }


            powerSet(nums, current, result, index + 1); // dontInclude
            current.add(nums[index]);
            powerSet(nums, current, result, index + 1); //include
            current.remove(current.size() - 1);
        }

        // tired to look whether this form of recursion to create new list at every recursive call would probably generate lot of waster GC
//     private void powerSet_worksButProbablyLessSpaceEfficient(int[] nums, List<Integer> current, List<List<Integer>> result, int index) {

//         if (index == nums.length) {
//             result.add(current);
//             return;
//         }

//         List<Integer> include = new ArrayList<>(current);
//         include.add(nums[index]);
//         powerSet(nums, new ArrayList<>(current), result, index+1); // dontInclude
//         powerSet(nums, include, result, index+1); //include
//     }
    }
}
