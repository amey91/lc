package main.java;

import main.java.commons.TreeNode;

public class InsertIntoBinarySearchTree {
    // 701. Insert into a Binary Search Tree
// https://leetcode.com/problems/insert-into-a-binary-search-tree/
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            TreeNode curr = root;
            TreeNode prev = null;

            while (curr != null) {
                prev = curr;
                if (curr.val > val) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }

            if (prev.val > val) {
                prev.left = new TreeNode(val);
            } else {
                prev.right = new TreeNode(val);
            }
            return root;
        }
    }
}
