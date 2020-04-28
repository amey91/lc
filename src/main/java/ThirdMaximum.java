package main.java;

// #414. Third Maximum Number
public class ThirdMaximum {
    class Solution {
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
