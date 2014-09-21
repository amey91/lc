package leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if(s==null)
			return 0;
		char[] c = s.toCharArray();
		int start = 0;
		int count=0;
		HashMap<Character, Integer> hm = new HashMap<>();
		for(int i=0;i<c.length;i++){
			if(!hm.containsKey(c[i])){
                hm.put(c[i], i);
                // was not getting accepted since I wasn't updating count in this case
                count=Math.max(count, i-start+1);
			} else {
			    //check if another char has not repeated after the last occurence of current char
                start=Math.max(start, hm.get(c[i])+1);
                hm.put(c[i],i);
                count=Math.max(count, i-start+1);
			}
		}
		return Math.max(count,c.length-start);
	}
}