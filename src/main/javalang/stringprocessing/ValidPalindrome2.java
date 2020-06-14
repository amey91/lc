package javalang.stringprocessing;

public class ValidPalindrome2 {
    // 680. Valid Palindrome II
// https://leetcode.com/problems/valid-palindrome-ii/

// clarifying questions
// what kind of digits can the string contain? smaller case

    // this solution iterates from edges into the center (since length of palindrome is known)
// when there is no match, I record the number of mimatches encountered till now and proceed after skipping
// either of the mismatches
    class Solution {
        public boolean validPalindrome(String s) {
            if (s == null) {
                return false;
            }

            char[] chars = s.toCharArray();
            // skip only 1 char
            return skipOnce(chars, 1, 0, chars.length - 1);
        }

        private boolean skipOnce(char[] chars, int canSkip, int left, int right) {
            // avoid recursion if possible since it is simple enough to iterate matches
            while (left < right && chars[left] == chars[right]) {
                left++;
                right--;
            }
            if (left >= right) {
                return true;
            }
            // chars are not equal and we are out of skips
            if (canSkip == 0) {
                return false;
            }
            return skipOnce(chars, canSkip - 1, left, right - 1) || skipOnce(chars, canSkip - 1, left + 1, right);
        }
    }
}
