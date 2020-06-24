package javasolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    // 249. Group Shifted Strings
// https://leetcode.com/problems/group-shifted-strings/

    // array iteration

    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            // ALGO
            // fidn the sequence
            // if sequqnce exists in the map, add to that value list
            // else create and then add to value list
            // return list of values

            if (strings == null || strings.length == 0) {
                return new ArrayList<>();
            }

            Map<String, List<String>> map = new HashMap<>();

            for (String s : strings) {
                String key = calculateKey(s);
                if (!map.containsKey(key)) {
                    map.put(key, new LinkedList<>());
                }
                map.get(key).add(s);
            }

            return new LinkedList<>(map.values());

        }

        private String calculateKey(String s) {
            if (s.length() == 1) {
                return "NULL"; // special bucket
            }
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            for (int i = 1; i < s.length(); i++) {
                int diff = chars[i - 1] - chars[i];

                // IMP: key space is within 0 and 26, otherwise a,z and b,a will match to different buckets
                if (diff < 0) {
                    diff += 26;
                }

                sb.append(diff);
            }
            return sb.toString();
        }
    }
}
