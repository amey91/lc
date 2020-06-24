package javasolutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {

    // this is my DFS solution and is interview friendlier than BFS solution.
    // 1. create adjacency list for graph
    // 2. do graph coloring with 2 colors (grey/false for nodes that we have seen true/black for nodes we have
    //    seen and have finished processing).
    // 3. build result string while doing dfs
    //
    //  Also remember how a dictionary is
    //  lexicographically arranged. Only the first diff letter contains ordering info. Rest after that do not contain any ordering info
    // cycle detection: happens during DFS coloring
    // IMPORtANT: the result is in reverse order of what we want! Dont forget to reverse it!
    // space : 1 for graph construction since alphabets are limited + V + E for DFS recusrsion stack
    // time : C for graph construction + V + E for DFS processing since each node is processed once = C + V + E. We know C >> V+ E, so we can say ~= C
    // where v = vertices in graph, E = edge in graph , c = total length of all words combined  in input words
    class Solution {
        public String alienOrder(String[] words) {
            if (words == null || words.length == 0) {
                return "";
            }

            Map<Character, Set<Character>> graph = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length();j ++) {

                    // put all so that final result contains everything and processing is easier later
                    if (!graph.containsKey(words[i].charAt(j))) {
                        graph.put(words[i].charAt(j), new HashSet<>());
                    }
                }
                if (i > 0) {
                    if (words[i-1].startsWith(words[i]) &&
                            words[i-1].length() > words[i].length()) {
                        // IMPORTANT dont forget this condition where prefix is after word
                        // e.g. (abcd, abc) is not allowed in common dictionary
                        return "";
                    }
                }
            }

            constructAdjacencyList(words, graph);

            Map<Character, Boolean> seen = new HashMap<>();

            StringBuilder sb = new StringBuilder();

            // dfs for all keys we have seen so far
            for (Character c : graph.keySet()) {
                if (!dfs(c, seen, graph, sb)) {
                    return "";
                }
            }

            // since this is DFS the firrst node is the deepest and that one has most dependencies.
            // In the answer we want, the letter with no dependeny is first. So we
            // reverse the dfs result to bring zero dependency items first
            return sb.reverse().toString();
        }

        private boolean dfs(Character currChar,
                            Map<Character, Boolean> seen,
                            Map<Character, Set<Character>> graph,
                            StringBuilder sb) {

            if (seen.containsKey(currChar)) {
                return seen.get(currChar);
            }
            seen.put(currChar, false);

            for (Character child : graph.get(currChar)) {

                // handle cycles!
                if (!dfs(child, seen, graph, sb)) {
                    return false;
                }

            }
            seen.put(currChar, true);
            sb.append(currChar);
            return true;
        }

        private void constructAdjacencyList(String[] words,
                                            Map<Character, Set<Character>> graph) {


            for (int i = 1; i < words.length; i++) {
                String w1 = words[i-1];
                String w2 = words[i];
                int j = 0;
                while (j < w1.length() &&
                        j < w2.length() &&
                        w1.charAt(j) == w2.charAt(j)) {
                    j++;
                }

                if (j < w1.length() && j < w2.length()) {
                    // first diff letter
                    graph.get(w1.charAt(j)).add(w2.charAt(j));
                }
            }
        }
    }


// This is the BFS solution that I had coded up earlier! It first selects all the nodes that have no depndencies and keeps track of incoming nodes
    // after we traverse nodes with zero dependencies we decrement incoming count for any child nodes and keep interating over the array for each element in BFS queue
    // cycle detection: after BFS is done, if the incoming count for any edge is > 0 then there is a cycle
//    class Solution {
//        public String alienOrder(String[] words) {
//            int[] incomingCount = new int[26];
//            Arrays.fill(incomingCount, -1);
//
//            Map<Character, Set<Character>> adjacencyList = new HashMap<>();
//
//
//            // get all chars
//            for (int i = 0; i < words.length; i++) {
//
//                // handle prefix coming after word e.g. (abc, ab) and equal words e.g. (z, z) which are valid according to expectations
//                // error: did not handle prefixes and equal words, had used conttains instead of startsWith
//                if (i > 0 &&
//                        !words[i - 1].equals(words[i]) &&
//                        words[i-1].startsWith(words[i])) {
//                    return "";
//                }
//
//                for (int j = 0; j < words[i].length(); j++) {
//                    char curr = words[i].charAt(j);
//                    if (!adjacencyList.containsKey(curr)) {
//                        adjacencyList.put(curr, new HashSet<>());
//                    }
//                    incomingCount[curr - 'a'] = 0;
//                }
//            }
//
//            populateAdjacencyList(adjacencyList, words, incomingCount);
//
//            StringBuilder sb = new StringBuilder();
//
//            // populate queue
//            ArrayDeque<Character> queue = new ArrayDeque<>();
//            Character prev = null;
//            for (int i = 0; i < incomingCount.length; i++) {
//                if (incomingCount[i] == 0) {
//                    queue.add((char)(i + 'a'));
//                }
//            }
//
//            while (!queue.isEmpty()) {
//                char curr = queue.poll();
//
//                for (char c : adjacencyList.get(curr)) {
//                    incomingCount[c - 'a']--;
//                    if (incomingCount[c - 'a'] == 0) {
//                        queue.add(c);
//                    }
//                }
//                sb.append(curr);
//            }
//
//
//            for (int i = 0;  i < incomingCount.length; i++) {
//
//                if (incomingCount[i] > 0) {
//                    // cycle!
//                    return "";
//                }
//            }
//            return sb.toString();
//        }
//
//        private void populateAdjacencyList(Map<Character, Set<Character>> adjacencyList, String[] words, int[] incomingCount) {
//            Character prevFirst = words[0].charAt(0);
//
//            // populate first diff letter adjacency
//            for (int index = 1; index < words.length; index++) {
//                String word1 = words[index-1];
//                String word2 = words[index];
//                int i = 0;
//                while (i < word1.length() && i < word2.length() && word1.charAt(i) == word2.charAt(i)) {
//                    i++;
//                }
//                if (i < word1.length() && i < word2.length() && !adjacencyList.get(word1.charAt(i)).contains(word2.charAt(i))) {
//                    incomingCount[word2.charAt(i) - 'a'] ++;
//                    adjacencyList.get(word1.charAt(i)).add(word2.charAt(i));
//                }
//            }
//        }
//    }



}
