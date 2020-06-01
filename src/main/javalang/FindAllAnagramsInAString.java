package javalang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    // 438. Find All Anagrams in a String
// https://leetcode.com/problems/find-all-anagrams-in-a-string/

    // 438. Find All Anagrams in a String
// https://leetcode.com/problems/find-all-anagrams-in-a-string/

    class Solution {

        // time = N
        // space = 1 (since array size is 26 always)
        public List<Integer> findAnagrams(String s, String p) {
            // maintain an array of p anagram and a running array of s chars of length p.length
            // at every stage, compare runinng array with anagram array
            // keep and return counter

            List<Integer> result = new ArrayList<>();
            if (s == null || p == null || p.length() > s.length()) {
                return result;
            }

            int[] anagramArray = new int[26];
            int[] runningArray = new int[26];

            for (char c : p.toCharArray()) {
                anagramArray[c - 'a']++;
            }

            int k = p.length();
            char[] input = s.toCharArray();
            for (int i = 0; i < k; i++) {
                runningArray[input[i] - 'a']++;
            }

            for (int i = 0; i <= s.length() - k; i++) {
                if (i > 0) {
                    runningArray[input[i - 1] - 'a']--;
                    runningArray[input[i + k - 1] - 'a']++;
                }
                if (Arrays.equals(runningArray, anagramArray)) {
                    result.add(i);
                }
            }
            return result;
        }
    }
}
