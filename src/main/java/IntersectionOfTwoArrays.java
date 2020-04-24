package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays {
//    #350. Intersection of Two Arrays II

    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null) {
                return null;
            }

            int[] smaller, larger;
            if (nums1.length > nums2.length) {
                smaller = nums2;
                larger = nums1;
            } else {
                smaller = nums1;
                larger = nums2;
            }
            // map of integer to count
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : smaller) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }

            int[] result = new int[Math.min(nums1.length, nums2.length)];
            int resultIndex = 0;
            for (int i=0; !map.isEmpty() && i<larger.length; i++) {
                if (map.containsKey(larger[i])) {
                    int count = map.get(larger[i]);
                    if (count == 1) {
                        map.remove(larger[i]);
                    } else {
                        map.put(larger[i], count -1);
                    }
                    result[resultIndex++] = larger[i];
                }
            }

            return Arrays.copyOf(result, resultIndex);
        }
    }
}
