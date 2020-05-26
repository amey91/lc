package javalang;

import javalang.commons.TreeNode;

public class SmallestStringFromLeaf {
    // 988. Smallest String Starting From Leaf
// https://leetcode.com/problems/smallest-string-starting-from-leaf/

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

// 6.14
// algorithm:

// implement dfs
// if at leaf node:
//     check stack value and compare to min stack
// else dfs of lef tand right

// 6.32
// rnan but wrong result

// 6.50 finished. Bug: want creating new arraydeque in compareDeckToMinDeque function for one of the conditions

    class Solution {


        // I first implemented using Stack, but this can be implemented using StringBuilder
        String minString = null;

        public String smallestFromLeaf(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            dfsForLeafNode(root, sb);
            return minString;
        }

        private void dfsForLeafNode(TreeNode node, StringBuilder sb) {
            if (node == null) {
                return;
            }
            sb.append((char)(node.val + 'a'));

            if (node.right == null && node.left == null) {
                // need to compare depth first
                sb = sb.reverse();
                if (minString == null || sb.toString().compareTo(minString) < 0) {
                    minString = sb.toString();
                }
                sb = sb.reverse();
            }
            dfsForLeafNode(node.left, sb);
            dfsForLeafNode(node.right, sb);

            // this is what allows me to use string builder instead of stack(deque)!!
            sb.deleteCharAt(sb.length() - 1);
        }

//     private void compareDeckToMinDeque(Deque<Integer> deck) {
//         if (minDeck == null) {
//             minDeck = new ArrayDeque<Integer>(deck);
//             return;
//         }
//         Iterator<Integer> minIter = minDeck.iterator();
//         Iterator<Integer> iter = deck.iterator();

//         while (minIter.hasNext() && iter.hasNext()) {
//             Integer min = minIter.next();
//             Integer num = iter.next();
//             if (min > num) {
//                 minDeck = new ArrayDeque<Integer>(deck);
//                 return;
//             } else if (num > min) {
//                 return;
//             }
//         }

//         if (minIter.hasNext()) {
//             // min has more values
//             minDeck = new ArrayDeque<Integer>(deck);
//         }
//     }
    }
}
