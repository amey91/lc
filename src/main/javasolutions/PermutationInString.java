package javasolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationInString {
    class Solution {


        // time = N * 26
        // space = 26 = 1
        // NOTE: can be optimized, but I dont want to at this point, its the same algorithm
        public boolean checkInclusion(String s1, String s2) {
            List<Integer> result = findAnagrams(s2, s1);
            return !result.isEmpty();
        }

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
