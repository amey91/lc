package javasolutions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets2_CombinationsWithDuplicates {

    // 90. Subsets II
// https://leetcode.com/problems/subsets-ii/

    class Solution {

        // Either include or dont include each value in input
        // To handle duplicates, we skip duplicate values when we are doing "dont include" part
        // This works because we need each permutation when we are including something (even duplicates)
        // However, if we run "dont include" scenario for all duplicates, it would produce duplicate result entries for each further include recursion
        // e.g. 1225
        // if we dont skip first 2, 2 entries for 125 will be present in answer
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();


            if (nums == null) {
                return result;
            }

            Arrays.sort(nums);
            List<Integer> list = new ArrayList<>();

            powerSet(nums, list, result, 0);
            return result;
        }

        private void powerSet(int[] nums, List<Integer> currList, List<List<Integer>> result, int index) {
            if (index == nums.length) {
                result.add(new ArrayList<>(currList));
                return;
            }


            // for dont include loop, skip all dupicate entries
            int temp = index;
            while (temp < nums.length - 1 && nums[temp] == nums[temp + 1]) {
                temp++;
            }
            powerSet(nums, currList, result, temp + 1); //  dont include

            // for include loop, include EVERY entry, even duplicates since we want power set
            currList.add(nums[index]);
            powerSet(nums, currList, result, index + 1); //  include
            currList.remove(currList.size() - 1);
        }
    }
}
