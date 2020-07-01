package javasolutions.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    // 139. Word Break
// https://leetcode.com/problems/word-break/
// Medium

    class Solution {

        // DP. Subsolutions for dp[i]=(dp[i-1] + inDict(i) || dp[i-2] + inDict(i-1 to i) || ... || dp[0] + inDict(1 to i))
        // subsolution for current depends on past solutions and can be built up from individual past sp results but combinainig that result with what ever is left over after that result
        // I tried using backtracking since this is deceptively similar to generating permutations but here we are actualy returning to the previous combination values after considering them once
        // N space
        // N^2 time
        public boolean wordBreak(String s, List<String> wordDict) {

            // dp[i]=true means there is some solution for [0 to i]
            boolean[] dp = new boolean[s.length()];

            // efficient lookup for dictionary
            Set<String> dict = new HashSet<>(wordDict);

            for (int i = 0; i < s.length(); i++) {

                // consider entire substring from beginning till i
                if (dict.contains(s.substring(0, i + 1))) {
                    dp[i] = true;
                    // no need to check iteratively
                    continue;
                }

                // check iteratively over previous dp entries; and stop at any first solution for this index since we dont care about how many solutions there are
                // IMPORTANT: if we want number of solutions, we keep going and keep adding counts even after finding one solution
                for (int j = 0; j < i; j++) {
                    if (dp[j] && dict.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[dp.length - 1];
        }

        /// trying to do to this via backtracking/combinations is REALllY tricky since the previously seen strings can also be repeated! This can be achieved with the
        // recursive permutations approach which creates a loop over all strings in the recursive body method, but where will this end? no idea. I dont know how to stop stack overflow here
        // e.g. for dict=[apple, pen] we can form applepenapple, but in terms in backtracking, we are able to consider apple again after considering it once in the beginning and moving on to pen.
        // So instead of trying to build upto that string, lets try to break the string into parts
//      public boolean wordBreak(String s, List<String> wordDict) {
//         // looks like a backtracking question to use permutations of given dict to try to see if we can form s
//         // algo:
//         // take the same word or take the next word and keep doing till we reach length;
//         // For not using the word, we always increment the index. For using, we keep the same index

//         StringBuilder sb = new StringBuilder();
//         return canForm(s, wordDict, sb, 0);
//     }

//     private boolean canForm(String s, List<String> wordDict, StringBuilder sb, int index) {
//         if(sb.length() > s.length() || index >= wordDict.size()) {
//             return false;
//         }

//         if (sb.length() == s.length()) {
//             return s.equals(sb.toString());
//         }

//         // dont include
//         if (canForm(s, wordDict, sb, index+1)) {
//             return true;
//         }

//         // include
//         sb.append(wordDict.get(index));
//         if (canForm(s, wordDict, sb, index)) {
//             return true;
//         }
//         for (int i = 0; i < wordDict.get(index).length(); i++) {
//             sb.deleteCharAt(sb.length() - 1);
//         }
//         return false;
//     }
    }
}
