package javasolutions.greedy;

import java.util.Arrays;

public class AssignCookies {

    // 455. Assign Cookies
// https://leetcode.com/problems/assign-cookies/

    class Solution {
        public int findContentChildren(int[] g, int[] s) {

            // to maximize children, we assign smallest cookies to the least greedy children
            Arrays.sort(g);
            Arrays.sort(s);

            int left = 0, right = 0, count = 0;

            while (left < g.length && right < s.length) {
                if (g[left] > s[right]) {
                    right++;
                } else {
                    count++;
                    right++;
                    left++;
                }
            }
            return count;
        }
    }
}
