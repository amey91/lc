package javasolutions;

// #647 https://leetcode.com/problems/palindromic-substrings/
public class CountPalindromicSubstrings {
    class Solution {
        public int countSubstrings(String s) {
            if (s==null || s.length()==0) {
                return 0;
            }
            if (s.length()==1) {
                return 1;
            }
            char[] chars = s.toCharArray();
            int sum = 0;
            for (int i=0; i<chars.length; i++) {
                // odd palindrome
                sum += countPalindromes(chars, i, i);

                // even palindrome
                if (i<chars.length-1) {
                    sum += countPalindromes(chars, i, i+1);
                }
            }
            return sum;
        }

        private int countPalindromes(char[] chars, int left, int right) {
            int sum = 0;
            while(left>=0 && right<chars.length && chars[left] == chars[right]) {
                sum++;
                left--;
                right++;
            }
            return sum;
        }
    }
}
