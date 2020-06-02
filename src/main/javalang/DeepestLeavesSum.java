package javalang;

import javalang.commons.TreeNode;

public class DeepestLeavesSum {
    // 1302. Deepest Leaves Sum
// https://leetcode.com/problems/deepest-leaves-sum/
    class Solution {

        public int deepestLeavesSum(TreeNode root) {
            int height = findHeight(root, 0);
            return findDeepestSum(root, 0, height);
        }

        private int findDeepestSum(TreeNode node, int currHeight, int height) {
            if (node == null) {
                return 0;
            }

            currHeight++;

            if (height == currHeight) {
                return node.val;
            }

            int total = 0;

            total += findDeepestSum(node.left, currHeight, height);
            total += findDeepestSum(node.right, currHeight, height);
            return total;

        }

        private int findHeight(TreeNode node, int currHeight) {
            if (node == null) {
                return 0;
            }

            currHeight++;
            if (node.left == null && node.right == null) {
                return currHeight;
            }

            int height = findHeight(node.left, currHeight);
            height = Math.max(height, findHeight(node.right, currHeight));
            return height;
        }

    }
}
