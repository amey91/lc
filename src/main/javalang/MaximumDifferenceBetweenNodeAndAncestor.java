package javalang;

import javalang.commons.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {
    // 1026. Maximum Difference Between Node and Ancestor
// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

    // to calcualte max diff for any ancestor, what we need are 2 extremes to compare against, thats it.
// this can be proved by assuming that there is a number that would produce a greater diff. Then that
// hypothetical number would have to exist before min or after max, which is a contradiction.
    class Solution {
        public int maxAncestorDiff(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return maxDiff(root, root.val, root.val);
        }

        private int maxDiff(TreeNode node, int min, int max) {
            if (node == null) {
                return 0;
            }

            int diff = Math.max(Math.abs(node.val - min), Math.abs(node.val - max));
            min = Math.min(node.val, min);
            max = Math.max(node.val, max);

            if (node.left != null) {
                diff = Math.max(maxDiff(node.left, min, max), diff);
            }

            if (node.right != null) {
                diff = Math.max(maxDiff(node.right, min, max), diff);
            }

            return diff;
        }
    }
}
