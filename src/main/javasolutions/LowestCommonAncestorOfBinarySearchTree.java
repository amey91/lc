package javasolutions;

import javasolutions.commons.TreeNode;

public class LowestCommonAncestorOfBinarySearchTree {

// LCA == (node.val == p.val || q.val) OR p and q are on opposides sides
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// 235. Lowest Common Ancestor of a Binary Search Tree

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int larger = p.val > q.val? p.val : q.val;
            int smaller = p.val > q.val? q.val : p.val;

            while(true) {
                if (root == null) {
                    return null;
                }
                if (root.val == larger || root.val == smaller ||
                            (root.val > smaller && root.val < larger) ) {
                    return root;
                }
                if (root.val < smaller) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
    }
}
