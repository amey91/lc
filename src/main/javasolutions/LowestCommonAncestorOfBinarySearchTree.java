package javasolutions;

import javasolutions.commons.TreeNode;

public class LowestCommonAncestorOfBinarySearchTree {

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// 235. Lowest Common Ancestor of a Binary Search Tree

    class Solution {

        // LCA == (node.val == p.val || q.val) OR p and q are on opposides sides
        // Dont recurse down if you find one of the nodes and just return that node. This works because it really doesn't matter if the second
        // node is in its subtree or not because
        //      1. if it is, then current node is LCA
        //      2. If it is not in subtree, then we will return the other node from whereever it is found and handle result while returning
        //          value from actual LCA node
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
