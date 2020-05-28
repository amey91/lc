package javalang;

public class LexicographicallySmallestEquivalentString {
    // 1061. Lexicographically Smallest Equivalent String
// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/

// Union find

    class Solution {
        public String smallestEquivalentString(String A, String B, String S) {
            if (A == null || B == null) {
                return S;
            }

            // union find
            int[] graph = new int[26];
            for (int i = 0; i < 26; i++) {
                graph[i] = i;
            }

            char[] a = A.toCharArray();
            char[] b = B.toCharArray();
            for (int i = 0; i < a.length; i++) {
                int aIndex = unionFind(graph, a[i] - 'a');
                int bIndex = unionFind(graph, b[i] - 'a');
                // always point to the smallest element
                if (aIndex > bIndex) {
                    graph[aIndex] = bIndex;
                } else {
                    graph[bIndex] = aIndex;
                }
            }

            StringBuilder sb = new StringBuilder();
            char[] s = S.toCharArray();
            for (int i = 0; i < s.length; i++) {
                sb.append((char) ('a' + unionFind(graph, s[i] - 'a')));
            }
            return sb.toString();
        }

        private int unionFind(int[] graph, int a) {
            while (graph[a] != a) {
                a = graph[a];
            }
            return a;
        }
    }
}
