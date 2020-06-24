package javasolutions.binarysearch;

import javasolutions.commons.TreeNode;

public class InorderSuccessorInBST {
    // 285. Inorder Successor in BST
// https://leetcode.com/problems/inorder-successor-in-bst/

    // time = logn
    // space = 1 + recursion
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null) {
                return null;
            }

            TreeNode result = null;

            // inorder SUCCESSOR is the smallest number that is larger than target value
            while (root != null) {
                if (root.val > p.val) {
                    result = root;
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return result;
        }

    }
}
