package main.java;

import main.java.commons.TreeNode;

public class SplitBST {

// 776. Split BST
// https://leetcode.com/problems/split-bst/

// 10.12
// came up with lame algo
// 11.09 full solution (optimal but code not very clean)
// 11.14 code optimized


// Gist:
// For every node, we return 2 nodes[], nodes[0] is all nodes smaller or equal than target, and nodes[1] is all nodes larger than target.

    // each stage of processing, we consider 3 possibilities:
// 1. root.val == target, then the right subtree is strictly larger than target
// 2. root.val < target then
//        target lies somewhere in right subtree, so node.right will be smaller of subsolutions
//        currentnode is part of smaller subtree, larger subtree returned may remain same
// 3. root.val > target then
//        curretn node is part of larger subtree
//        node.left will be smaller of the subsolutions
    class Solution {
        public TreeNode[] splitBST(TreeNode node, int V) {
            if (node == null) {
                // base case
                return new TreeNode[2];
            }

            if (node.val == V) {
                // if we have reached node, then right subtree is larger and current node is in smaller subsolutions
                TreeNode[] result = new TreeNode[2];
                result[0] = node;
                TreeNode temp = node.right;
                node.right = null;
                result[1] = temp;
                return result;
            } else if (node.val > V) {
                // if node value is greater than target, target is on left side and current node is part of larger subsolution
                TreeNode[] result = splitBST(node.left, V);

                // current node is part of larger subsolution (same as above comment)
                node.left = result[1];
                result[1] = node;
                return result;
            } else {
                // if value of node was less than target, then solution is in right subtree and current node is part of smaller subsolution
                TreeNode[] result = splitBST(node.right, V);
                node.right = result[0];
                result[0] = node;
                return result;
            }
        }
    }
}
