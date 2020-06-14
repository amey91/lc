package javalang.stringprocessing;

public class ValidPalindrome {

    class Solution {

// 125. Valid Palindrome
//     https://leetcode.com/problems/valid-palindrome/

        // time = N
        // space = 1
        public boolean isPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }
            s = s.toLowerCase();
            int l = 0;
            int r = s.length()-1;

            while (l < r) {
                if (!(s.charAt(l) >= 'a' && s.charAt(l) <= 'z' ||
                              s.charAt(l) >= '0'  && s.charAt(l) <= '9')) {
                    l++;
                } else if (!(s.charAt(r) >= 'a' && s.charAt(r) <= 'z' ||
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
    }

//    public boolean isPalindrome_old(String s) {
//        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
//        return s.equals(new StringBuilder(s).reverse().toString());
//    }
}