package javalang.binarysearch;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
    // 409. Longest Palindrome
// https://leetcode.com/problems/longest-palindrome/
    class Solution {
        public int longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            char[] chars = s.toCharArray();
            int length = 0;
            Set<Character> set = new HashSet<>();
            for (char c : chars) {
                if (set.contains(c)) {
                    length += 2;
                    set.remove(c);
                } else {
                    set.add(c);
                }
            }

            return set.size() > 0 ? length + 1 : length;

        }
    }
}
