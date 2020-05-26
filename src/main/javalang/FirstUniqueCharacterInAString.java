package javalang;

// #387. First Unique Character in a String

import java.util.Arrays;

public class FirstUniqueCharacterInAString {
    static class Solution {

        // there are 2 approaches to this problem
        // 1. let the array hold indexes (recommended)
        // 2. let the array hold counts or frequency (you will need to re-iterate array to find which single occurence character was first)

        // time = n for iteration AND constant for finding max
        // space = constant

        private static final Integer INIT = -2;
        private static final Integer DUPLICATE = -1;

        public int firstUniqChar(String s) {
            if (s == null || s.length() == 0) {
                return -1;
            }
            int[] counts = new int[26];
            char[] chars = s.toCharArray();
            Arrays.fill(counts, INIT);
            for (int i = 0; i< chars.length;  i++) {
                counts[chars[i] - 'a'] = counts[chars[i] - 'a'] == INIT? i: DUPLICATE;
            }

            Integer min = null;
            for (int i = 0; i< 26; i++) {
                if (counts[i] >= 0) {
                    if (min == null) {
                        min = counts[i];
                    } else {
                        min = Math.min(counts[i], min);
                    }
                }
            }
            return min == null? -1 : min;
        }
    }
}
