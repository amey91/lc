package javalang;

import java.util.ArrayList;
import java.util.List;

// #442. Find All Duplicates in an Array
public class FindDuplicatesInArray {
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {

            // I can do this since all inputs are in this range
            boolean[] arr= new boolean[nums.length + 1];

            List<Integer> duplicates = new ArrayList<>();
            for (int num : nums) {
                if (arr[num]) {
                    duplicates.add(num);
                } else {
                    arr[num] = true;
                }
            }
            return duplicates;
        }
    }
}
