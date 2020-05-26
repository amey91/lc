package javalang;

import javalang.commons.TreeNode;

public class SearchInBinarySearchTree {
    // 700. Search in a Binary Search Tree
// https://leetcode.com/problems/search-in-a-binary-search-tree/
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            if (root.val == val) {
                return root;
            }
            if (root.val < val) {
                return searchBST(root.right, val);
            }
            return searchBST(root.left, val);
        }
    }
}
