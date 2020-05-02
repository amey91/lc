package main.java;

import main.java.commons.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return heightDiff(root) >= 0;

    }

    private int heightDiff(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        int right = heightDiff(node.right);
        int left = heightDiff(node.left);

        if (right == -1 || left == -1)
            return -1;
        if (Math.abs(right - left) > 1)
            return -1;

        return Math.max(right, left) + 1;


    }
}