package javalang.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    // 17. Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// backtracking!
    class Solution {

        // for every number which maps to current phone key, get corresponding numbers and for each of those mapped numbers,
        // fill the corresponding spot and move forward recursively before moving to the second number for current spot.
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return result;
            }

            char[] chars = digits.toCharArray();
            StringBuilder sb = new StringBuilder();
            getCombinations(chars, result, sb, 0);
            return result;
        }

        private void getCombinations(char[] chars, List<String> result, StringBuilder sb, int index) {
            if (index >= chars.length) {
                result.add(sb.toString());
                return;
            }

            // string.valueOf gives 3x faster performance than concatination using chars[index] + ""
            int keypadNumber = Integer.parseInt(String.valueOf(chars[index]));

            char[] possibleKeys = KEYMAP[keypadNumber];

            for (char num : possibleKeys) {
                sb.append(num);
                getCombinations(chars, result, sb, index + 1);
                // clear current number before trying the enxt number for this key
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        private char[][] KEYMAP = new char[][]{
                new char[0],
                new char[0],
                new char[]{'a', 'b', 'c'},
                new char[]{'d', 'e', 'f'},
                new char[]{'g', 'h', 'i'},
                new char[]{'j', 'k', 'l'},
                new char[]{'m', 'n', 'o'},
                new char[]{'p', 'q', 'r', 's'},
                new char[]{'t', 'u', 'v'},
                new char[]{'w', 'x', 'y', 'z'}
        };
    }
}