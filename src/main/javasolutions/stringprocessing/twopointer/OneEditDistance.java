package javasolutions.stringprocessing.twopointer;

public class OneEditDistance {
    // 161. One Edit Distance
// https://leetcode.com/problems/one-edit-distance/
// 2 pointer approach

    class Solution {

        // 2 pointer!
        // space = 1
        // time = N
        // algo: get smaller and bigger of the 2 strings. When a char mismatches,
        // if hte lengths of 2 strings are same, then that char can be replaced
        // if the lengths of 2 strings are not same, then only option is to insert into smaller string.
        public boolean isOneEditDistance(String s, String t) {

            // Base conditions. Also, even if strings are equal, they are not 1-distance apart
            if (s == null || t == null || s.equals(t) || Math.abs(s.length() - t.length()) > 1) {
                return false;
            }
            int edits = 1;
            String smaller = s.length() > t.length() ? t : s;
            String bigger = s.length() > t.length() ? s : t;

            return isReachable(smaller, 0, bigger, 0, edits);
        }

        private boolean isReachable(String smaller, int sIndex, String bigger, int bIndex, int edits) {
            if (bIndex == bigger.length() && sIndex == smaller.length()) {
                return true;
            }

            if (bIndex == bigger.length() || sIndex == smaller.length()) {
                // assert we have not seen another difference till now
                return edits == 1;
            }

            if (smaller.charAt(sIndex) != bigger.charAt(bIndex)) {
                if (edits == 0) {
                    return false;
                }

                edits--;

                if (smaller.length() != bigger.length()) {
                    // only option is to insert into smaller string
                    return isReachable(smaller, sIndex, bigger, bIndex + 1, edits);
                } else {
                    // if both strings are same length, then skip these chars
                    return isReachable(smaller, sIndex + 1, bigger, bIndex + 1, edits);
                }
            } else {
                // increment both pointers
                return isReachable(smaller, sIndex + 1, bigger, bIndex + 1, edits);
            }
        }
    }
}
