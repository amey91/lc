package main.java;

import main.java.commons.TreeNode;

public class MergeTwoBinaryTrees {
    // 617. Merge Two Binary Trees
// https://leetcode.com/problems/merge-two-binary-trees/
    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }
            TreeNode newNode = new TreeNode(t1.val + t2.val);
            newNode.left = mergeTrees(t1.left, t2.left);
            newNode.right = mergeTrees(t1.right, t2.right);
            return newNode;
        }
    }
}
