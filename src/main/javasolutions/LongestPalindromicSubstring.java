package javasolutions;

// #5 https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {

	class Solution {
		public String longestPalindrome(String s) {
			if (s== null || s.length() <= 1) {
				return s;
			}
			char[] chars = s.toCharArray();
			int length = 0;
			int maxLeft = 0;
			int maxRight = 0;
			for (int i = 0; i<chars.length;i++) {
				int[] indexes = findPalindrome(chars, i, i);
				if (indexes!=null && length<indexes[1]-indexes[0]+1) {
					length = indexes[1]-indexes[0]+1;
					maxLeft=indexes[0];
					maxRight=indexes[1];
				}
				if (i < chars.length - 1) {
					indexes = findPalindrome(chars, i, i+1);
					if (indexes!=null && length<indexes[1]-indexes[0]+1) {
						length = indexes[1]-indexes[0]+1;
						maxLeft=indexes[0];
						maxRight=indexes[1];
					}
				}
			}
			return s.substring(maxLeft, maxRight+1);
		}

		private int[] findPalindrome(char[] chars, int left, int right) {
			while(left>=0 && right<chars.length && chars[left] == chars[right]) {
				left--;
				right++;
			}
			if (chars[left+1]==chars[right-1]) {
				// palindrome found
				// NOTE: I do lef++ and right-- because the indexes have already breached bounds when while loop ends
				return new int[]{left+1, right-1};
			}
			// palindrome not found
			return null;
		}
	}
}