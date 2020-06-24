package javasolutions.trie;

public class AddAndSearchWordDataStructureDesign {
    // 211. Add and Search Word - Data structure design
// https://leetcode.com/problems/add-and-search-word-data-structure-design/


    // We implement a trie in this problem.
// INSERT time = N space = N
// SEARCH time = N; worstcase time = 26 ^ N; space = 1
    class WordDictionary {

        class Node {
            public Node[] children;
            public int count; // count of words ending here

            public Node() {
                this.children = new Node[26];
                this.count = 0;
            }
        }

        Node root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {

            // cat
            insert(root, word, 0);
        }

        // index = 3
        // char = -
        // node = t
        private void insert(Node node, String word, int index) {
            if (index == word.length()) {
                node.count++;
                return;
            }

            if (node.children[word.charAt(index) - 'a'] == null) {
                node.children[word.charAt(index) - 'a'] = new Node();
            }

            insert(node.children[word.charAt(index) - 'a'], word, index + 1);

        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return search(root, word, 0);
        }

        // c.t
        // index = 2  = t
        // char = t
        // node = root -> c -> a
        private boolean search(Node node, String word, int index) {
            if (node == null) {
                return false;
            }
            if (index == word.length()) {
                return node.count > 0;
            }

            char c = word.charAt(index);
            if (c == '.') {
                for (int i = 0; i < node.children.length; i++) {
                    if (node.children[i] != null && search(node.children[i], word, index + 1)) {
                        return true;
                    }
                }
            } else {
                return search(node.children[word.charAt(index) - 'a'], word, index + 1);
            }
            return false;
        }
    }
}
