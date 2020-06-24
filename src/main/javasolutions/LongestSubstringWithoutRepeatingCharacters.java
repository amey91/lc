package javasolutions;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
	class Solution {

		// we iterate over a sliding window and keep recording the digits we encounter. If there is a duplicate,
		// the new substring should start from max of current start and the (index+1) of the last occurrence of the element
		public int lengthOfLongestSubstring(String s) {

			if (s == null) {
				return 0;
			}
			if (s.length() <= 1) {
				return s.length();
			}

			// abba
			char[] charArr = s.toCharArray();

			int startFromIndex = 0;
			int length = 0;

			// maps value to previously seen on index
			int[] prevIndexes = new int[256];

			Arrays.fill(prevIndexes, -1);

			for (int i = 0; i<charArr.length; i++) { // i=2
				if (prevIndexes[charArr[i]] >= 0) {
					int oldPreviousIndex = prevIndexes[charArr[i]];

					// start from max of current start and last occurrence of this duplicate (since current start may already be ahead of last occurence e.g. abba)
					startFromIndex = Math.max(startFromIndex, oldPreviousIndex +1); // 2
				}
				prevIndexes[charArr[i]] = i; // a = 0 b=1
				length = Math.max(length, i - startFromIndex + 1); // 2
			}
			return length;
		}

//
//		public int lengthOfLongestSubstring_sameSolutionButWithMap(String s) {
//
//			if (s == null) {
//				return 0;
//			}
//			if (s.length() <= 1) {
//				return s.length();
//			}
//
//			char[] charArr = s.toCharArray();
//
//			int startFromIndex = 0;
//			int length = 0;
//			// maps value to previously seen on index
//			Map<Character, Integer> map = new HashMap<>();
//			for (int i = 0; i<charArr.length; i++) { // i=2
//				if (map.containsKey(charArr[i])) {
//					int oldPreviousIndex = map.get(charArr[i]);
//					startFromIndex = Math.max(startFromIndex, oldPreviousIndex + 1); // 2
//				}
//				map.put(charArr[i], i); // a=0,b=2
//				length = Math.max(length, i - startFromIndex + 1); // 2
//			}
//			return length;
//		}
	}
}