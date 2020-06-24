package javasolutions;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
    // 266. Palindrome Permutation
// https://leetcode.com/problems/palindrome-permutation/
    class Solution {

        // n time
        // n space
        public boolean canPermutePalindrome(String s) {
            if (s == null) {
                return false;
            }

            if (s.length() < 2) {
                return true;
            }

            char[] chars = s.toCharArray();

            Set<Character> set = new HashSet<>();

            for (char c : chars) {
                if (set.contains(c)) {
                    set.remove(c);
                } else {
                    set.add(c);
                }
            }

            return set.size() <= 1;
        }
    }
}
