package javasolutions;

import javasolutions.commons.TreeNode;

public class InvertBinaryTree {
    // 226. Invert Binary Tree
// https://leetcode.com/problems/invert-binary-tree/
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return root;
            }

            if (root.left == null && root.right == null) {
                return root;
            }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}
