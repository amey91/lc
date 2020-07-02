package javasolutions.arrayprocessing;

// #414. Third Maximum Number
public class ThirdMaximum {

    class Solution {

        // IMPORTANT:
        // Approach 1: this solution keeps 3 pointers,
        // Approach 2: but for a K solution, we can create K+1 sized array. If the new
        // number is greater than largest, then insert into K+1 and sort, repeat for each numbers and return kth index of array
        public int thirdMax(int[] nums) {

            Integer first = null;
            Integer second = null;
            Integer third = null;

            for (int num: nums) {
                if (first == null || num >= first) {
                    if (first == null || num > first) {
                        third = second;
                        second = first;
                        first = num;
                    }
                } else if (second == null || num >= second) {
                    if (second == null || num > second) {
                        third = second;
                        second = num;
                    }
                } else if (third == null || num >= third) {
                    third = num;
                }
            }

            return third != null ? third : first;

        }
    }
}
