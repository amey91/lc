package main.java;

import main.java.commons.TreeNode;

public class ClosestBinarySearchTreeValue {
    // 270. Closest Binary Search Tree Value
// https://leetcode.com/problems/closest-binary-search-tree-value/
    class Solution {

        double minDiff = 0;
        int minValue = 0;

        public int closestValue(TreeNode root, double target) {
            if (root == null) {
                return Integer.MAX_VALUE;
            }
            minDiff = Math.abs(root.val - target);
            minValue = root.val;
            findClosest(root.left, target);
            findClosest(root.right, target);
            return minValue;
        }

        private void findClosest(TreeNode root, double target) {
            if (root == null) {
                return;
            }
            if (Math.abs(root.val - target) <= minDiff) {
                minValue = root.val;
                minDiff = Math.abs(root.val - target);
            }
            if (target < root.val) {
                findClosest(root.left, target);
            } else {
                findClosest(root.right, target);
            }
        }
    }

}
