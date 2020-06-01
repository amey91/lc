package javalang;

import java.util.Arrays;

public class ValidAnagram {
    // 242. Valid Anagram
// https://leetcode.com/problems/valid-anagram/
    class Solution {

        // NlogN time
        // 1 space
        public boolean isAnagram(String s, String t) {
            if (s == null || t == null) {
                return false;
            }

            char[] s_ = s.toCharArray();
            char[] t_ = t.toCharArray();

            Arrays.sort(s_);
            Arrays.sort(t_);

            return Arrays.equals(s_, t_);
        }
    }
}
