package javalang.greedy;

public class SplitAStringInBalancedStrings {

    // 1221. Split a String in Balanced Strings
// https://leetcode.com/problems/split-a-string-in-balanced-strings/

    class Solution {

        // since we want max count, we just increase our answer each time there is a match in R and L count

        public int balancedStringSplit(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            char[] chars = s.toCharArray();
            int n = chars.length;

            int ls = 0, rs = 0, count = 0;

            for (int i = 0; i < n; i++) {
                if (chars[i] == 'R') {
                    rs++;
                } else {
                    ls++;
                }

                if (rs == ls) {
                    count++;
                }
            }
            return count;

        }
    }
}
