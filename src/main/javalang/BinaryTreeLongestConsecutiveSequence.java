package javalang;

import javalang.commons.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
    // 298. Binary Tree Longest Consecutive Sequence
// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/

// at every node
// pass currentLength and parentValue
// if currentVal = parentValue+1 then recurse left and right with currentLength+1
// else recurse left and right with currentLength = 0
// return max(lengths)

    class Solution {
        public int longestConsecutive(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return Math.max(countPathLength(root.left, 1, root.val),
                            countPathLength(root.right, 1, root.val));
        }

        private int countPathLength(TreeNode node, int currLength, int parentValue) {
            if (node == null) {
                return currLength;
            }
            if (node.val == parentValue + 1) {
                int left = countPathLength(node.left, currLength + 1, node.val);
                int right = countPathLength(node.right, currLength + 1, node.val);
                return Math.max(left, right);
            } else {
                int left = countPathLength(node.left, 1, node.val);
                int right = countPathLength(node.right, 1, node.val);
                return Math.max(currLength, Math.max(left, right));
            }
        }
    }
}
