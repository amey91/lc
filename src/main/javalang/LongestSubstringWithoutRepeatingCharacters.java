package javalang;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	class Solution {
		public int lengthOfLongestSubstring(String s) {

			if (s == null) {
				return 0;
			}
			if (s.length() <= 1) {
				return s.length();
			}

			char[] charArr = s.toCharArray();

			int startFromIndex = 0;
			int length = 0;
			// maps value to previously seen on index
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i<charArr.length; i++) { // i=2
				if (map.containsKey(charArr[i])) {
					int oldPreviousIndex = map.get(charArr[i]);
					startFromIndex = Math.max(startFromIndex, oldPreviousIndex + 1); // 2
				}
				map.put(charArr[i], i); // a=0,b=2
				length = Math.max(length, i - startFromIndex + 1); // 2
			}
			return length;
		}
	}
}