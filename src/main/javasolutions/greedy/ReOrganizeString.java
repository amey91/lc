package javasolutions.greedy;

// 767. Reorganize String
// https://leetcode.com/problems/reorganize-string
// Medium

public class ReOrganizeString {

    class Solution {

        // first count max freq char and fill it in even spots
        // then fill all others that are left over in odd spots
        // we are guaranteed only 2 traversals of result array since we only fill odd and even positions once
        // time = N for constructing freq counts
        // space = N
        public String reorganizeString(String S) {
            // max length pf any char should be S.length/2
            // fill in even positions first
            // then fill in odd positions

            int[] f = new int[26];

            int maxFreq = 0;
            int maxFreqIndex = 0;
            for (int i = 0; i < S.length(); i++) {
                f[S.charAt(i) - 'a']++;
                if (f[S.charAt(i) - 'a'] > maxFreq) {
                    maxFreq = f[S.charAt(i) - 'a'];
                    maxFreqIndex = S.charAt(i) - 'a';
                }
            }


            if (f[maxFreqIndex] > (S.length() + 1) / 2) {
                return "";
            }

            int index = 0;
            char[] chars = new char[S.length()];
            while (f[maxFreqIndex] > 0) {
                chars[index] = (char) ('a' + maxFreqIndex);
                f[maxFreqIndex]--;
                index += 2;
            }

            for (int i = 0; i < f.length; i++) {
                while (f[i] > 0) {
                    if (index >= chars.length) {
                        // we loop over the array only twice since we fill even positions and then odd positions, so index caan be set to 1 here
                        index = 1;
                    }
                    chars[index] = (char) ('a' + i);
                    f[i]--;
                    index += 2;
                }
            }
            return String.valueOf(chars);
        }


//     // time = NlogN for sort + NlogN for PQ processing
//     // space = N
//     // arrange frequencies in max heap for greedy algo. At each point, greedily take the long-poll which will be the element with most freqquency and assign a spot to it
//     // at each point, take 2 top elements from the PQ. The solution can be extended to K nodes as well by polling K nodes instead of 2.
//     public String reorganizeString_genericSolutionForNDistance(String S) {

//         // create PW of requency counts and pop 2 each time
//         // if ppq size is 1, then return ""
//         if (S== null || S.length() == 0) {
//             return "";
//         }
//         Map<Character, Integer> map = new HashMap<>();

//         for (int i = 0; i < S.length(); i++) {
//             char c = S.charAt(i);
//             map.put(c, map.getOrDefault(c, 0) +1);
//         }

//         PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(map.size(), (a,b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());

//         pq.addAll(map.entrySet());

//         if ((S.length() -
//              pq.peek().getValue()) <
//                     pq.peek().getValue() - 1) {
//             return "";
//         }

//         StringBuilder sb = new StringBuilder();

//         while (!pq.isEmpty()) {

//             Map.Entry<Character,Integer> e1 = pq.poll();
//             Map.Entry<Character,Integer> e2 = null;
//             sb.append(e1.getKey());

//             // we can pop N elements here. Right now, N = 2 (since we want at least 1 distance between 2 occurrences)
//             if (!pq.isEmpty()) {
//                 e2 = pq.poll();
//                 sb.append(e2.getKey());
//             }

//             if (e1.getValue() > 1) {
//                 e1.setValue(e1.getValue() -1);
//                 pq.offer(e1);
//             }

//             if (e2 != null && e2.getValue() > 1) {
//                 e2.setValue(e2.getValue() -1);
//                 pq.offer(e2);
//             }
//         }

//         return sb.toString();
//     }
    }
}
