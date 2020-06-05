package javalang.arrayprocessing;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    // 383. Ransom Note
// https://leetcode.com/problems/ransom-note/
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (magazine == null || ransomNote == null) {
                return false;
            }

            char[] m = magazine.toCharArray();

            Map<Character, Integer> map = new HashMap<>(m.length);
            for (char c : m) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (char c : ransomNote.toCharArray()) {
                Integer count = map.get(c);
                if (count == null) {
                    return false;
                } else if (count == 1) {
                    map.remove(c);
                } else {
                    map.put(c, count - 1);
                }
            }
            return true;
        }
    }
}
