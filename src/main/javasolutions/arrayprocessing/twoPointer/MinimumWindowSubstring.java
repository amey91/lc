package javasolutions.arrayprocessing.twoPointer;

public class MinimumWindowSubstring {
    // 76. Minimum Window Substring
// https://leetcode.com/problems/minimum-window-substring/
    class Solution {

        // we maintain 2 pointers. Right is for increasing window. Left fo decreasing it
        // when conditions are satisfied, move left to try to minimize length and continue till condition is broken.
        public String minWindow(String s, String t) {

            if (s == null || t == null || t.length() == 0 || s.length() == 0) {
                return "";
            }

            int[] chars = new int[60];
            for (int i = 0; i < t.length(); i++) {
                chars[t.charAt(i) - 'A']++;
            }

            int[] running = new int[60];
            int left = 0;
            int right = 0;
            int minLeft = 0;
            int minRight = 0;
            Integer length = null;

            // for entire bigger string
            while (right < s.length()) {
                running[s.charAt(right) - 'A']++;

                // if conditions are satisfied, then try reducing window
                while (left <= right && fulfills(running, chars)) {
                    if (length == null) {
                        length = right - left + 1;
                        minRight = right;
                        minLeft = left;
                    } else if (right - left + 1 < length) {
                        length = right - left + 1;
                        minLeft = left;
                        minRight = right;
                    }
                    running[s.charAt(left) - 'A']--;
                    left++;
                }

                right++;
            }

            // it is a requirement to return empty substring for no window
            return length == null ? "" : s.substring(minLeft, minRight + 1);
        }

        // this can be replaced by any condition e.g. max K distinct characters etc.
        private boolean fulfills(int[] actual, int[] desired) {
            for (int i = 0; i < actual.length; i++) {
                if (desired[i] > actual[i]) {
                    return false;
                }
            }
            return true;

        }
    }
}
