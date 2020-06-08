package javalang.arrayprocessing;

import java.util.HashMap;
import java.util.Map;

public class LongestArrayWithAtmostKDistinctCharacters {

// 340. Longest Substring with At Most K Distinct Characters
// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/


    // time = 2N = N
// space = k where k is desired number of distince characters
// we maintain a sliding window and a map for characters to frequency for that sliding window. If the size of the map > k then delete entries from left side of
// sliding window till the map size comes to below k
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (s == null || s.length() == 0 || k == 0) {
                return 0;
            }

            char[] chars = s.toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            int start = 0;
            int maxLength = 1;
            for (int i = 0; i < chars.length; i++) {
                char newChar = chars[i];
                map.put(newChar, map.getOrDefault(newChar, 0) + 1);
                if (map.size() > k) {
                    while (map.size() > k) {
                        char toRemove = chars[start];
                        start++;
                        int count = map.get(toRemove);
                        if (count == 1) {
                            map.remove(toRemove);
                        } else {
                            map.put(toRemove, count - 1);
                        }
                    }
                }
                maxLength = Math.max(maxLength, i - start + 1);

            }

            return maxLength;


        }
    }
}
