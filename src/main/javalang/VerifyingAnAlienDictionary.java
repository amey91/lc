package javalang;

public class VerifyingAnAlienDictionary {
    // https://leetcode.com/problems/verifying-an-alien-dictionary/
// 953. Verifying an Alien Dictionary

// lexicographic comparison

    class Solution {
        public boolean isAlienSorted(String[] words, String dict) {
            // hi lc
            // hl
            if (words == null || dict == null) {
                return false;
            }
            int[] order = new int[26];
            char[] chars = dict.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                order[chars[i] - 'a'] = i; // h=0 l=1
            }

            for (int i = 1; i < words.length; i++) {
                if (!orderCorrect(words[i - 1], words[i], order)) {
                    return false;
                }
            }
            return true;
        }

        private boolean orderCorrect(String word1, String word2, int[] order) {

            char[] w1 = word1.toCharArray(); // hi
            char[] w2 = word2.toCharArray(); // ls

            for (int i = 0; i < w1.length && i < w2.length; i++) {
                if (w1[i] != w2[i]) {
                    int o2 = order[w2[i] - 'a'];
                    int o1 = order[w1[i] - 'a'];
                    return o1 < o2;
                }
            }
            if (w1.length > w2.length) {
                return false;
            }
            return true;
        }
    }
}
