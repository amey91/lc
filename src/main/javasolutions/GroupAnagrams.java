package javasolutions;

import java.util.*;

public class GroupAnagrams {
    // 49. Group Anagrams
// https://leetcode.com/problems/group-anagrams/
// IMPORTANT/CRITICAL: there is a better solution to count the palindrome letters in an array and then generate a string from the
// array. It is important to separate each letter by delimiter because we do not want to count 1a1b same as 11a
    class Solution {


        // time = N * KlogK for sorting each string in the list, K is length of individual string
        // space = N
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>(strs.length);
            if (strs == null) {
                return new ArrayList<>();
            }
            for (String s : strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);
                if (!map.containsKey(sorted)) {
                    map.put(sorted, new LinkedList<>());
                }
                map.get(sorted).add(s);
            }

            return new ArrayList<>(map.values());

        }
    }
}