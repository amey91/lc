package javalang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int l = 0;
        int r = s.length()-1;

        while (l < r) {
            if (!(s.charAt(l) >= 'a' && s.charAt(l) <= 'a' ||
                          s.charAt(l) >= '0'  && s.charAt(l) <= '9')) {
                l++;
            } else if (!(s.charAt(r) >= 'a' && s.charAt(r) <= 'a' ||
                                 s.charAt(r) >= '0'  && s.charAt(r) <= '9')) {
                r--;
            } else if (s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                l++; r--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new Solution().isPalindrome("race a car");
    }
}