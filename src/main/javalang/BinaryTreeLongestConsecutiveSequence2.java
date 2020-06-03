package javalang;

import javalang.commons.TreeNode;

public class BinaryTreeLongestConsecutiveSequence2 {


// 549. Binary Tree Longest Consecutive Sequence II
// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/

    // better readable solution is available in discussion section https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/discuss/101509/Java-recursively-compute-ascending-and-descending-sequence
    class Solution {

        // solution parses every node and at every node, we start search for incrementing and decrementing sequence on both sides
        // need to keep in mind that if one side is incrementing, other will be decrementing
        public int longestConsecutive(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int max = 0;
            max = Math.max(max, longestConsecutive(root.left));
            max = Math.max(max, longestConsecutive(root.right));
            max = Math.max(max, lCHelper(root));
            return max;
        }

        // at every node, start a fresh search on both side for either increasing or decreasing sequence
        private int lCHelper(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int gradient = 1;

            // handle 3, 2, 1
            int firstGradient = lcHelperInternal(node.left, node.val + gradient, gradient);
            firstGradient += lcHelperInternal(node.right, node.val - gradient, -gradient);

            // handle 1, 2, 3
            int secondGradient = lcHelperInternal(node.left, node.val - gradient, -gradient);
            secondGradient += lcHelperInternal(node.right, node.val + gradient, gradient);

            return 1 + Math.max(firstGradient, secondGradient);
        }

        // continue counting sequence till sequence is satisfied
        private int lcHelperInternal(TreeNode node, int expectedValue, int gradient) {
            if (node == null || expectedValue != node.val) {
                return 0;
            }
            int left = lcHelperInternal(node.left, node.val + gradient, gradient);
            int right = lcHelperInternal(node.right, node.val + gradient, gradient);
            return 1 + Math.max(left, right);
        }
    }
}
