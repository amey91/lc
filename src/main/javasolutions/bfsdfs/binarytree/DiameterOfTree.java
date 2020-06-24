package javasolutions.bfsdfs.binarytree;

import javasolutions.commons.TreeNode;

public class DiameterOfTree {
    // 543. Diameter of Binary Tree
// https://leetcode.com/problems/diameter-of-binary-tree/


    // uses DFS to go to each node once
    //
    class Solution {

        int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            diameterInternal(root);

            return max;
        }

        private int diameterInternal(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = diameterInternal(root.left);
            int right = diameterInternal(root.right);

            // the question is weird, it wants the length between the nodes, but it actually wants to exclude the current node (or maybe the one of the leaf nodes?) in the answer.
            max = Math.max(max, left + right);

            // while returning, we count the current node in the best possible length from this node to one of the noes below it so that the nodes above can calculate their own max paths
            return Math.max(left, right) + 1;
        }
    }
}
