package javasolutions;

import javasolutions.commons.TreeNode;

public class LowestCommonAncestorInBinaryTree {
    // 236. Lowest Common Ancestor of a Binary Tree
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    class Solution {

        // Dont recurse down if you find one of the nodes and just return that node. This works because it really doesn't matter if the second
        // node is in its subtree or not because
        //      1. if it is, then current node is LCA
        //      2. If it is not in subtree, then we will return the other node from whereever it is found and handle result while returning
        //          value from actual LCA node
        // time = N
        // space = 1
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            // immediately return if I find one of the values
            if (root == null || root.val == p.val || root.val == q.val) {
                return root;
            }

            // else find is left and right contain any nodes we are interested in
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null) {
                return root;
            }
            return left == null? right: left;

        }


        // this solution counts the occurrences of p and q in both side of the tree which
        // is NOT required because absolute counts really dont matter here. What matters is
        // whether the right and left side contain p or q or not
        TreeNode solution = null;

        public TreeNode lowestCommonAncestor_mySolutionOld(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }

            traversal(root, p , q);
            return solution;
        }

        private int traversal(TreeNode node, TreeNode p, TreeNode q) {
            if (node == null) {
                return 0;
            }
            int count = 0;
            int left = traversal(node.left, p, q);
            int right = traversal(node.right , p, q);
            if (left == 1 && right == 1) {
                solution = node;
                return 2;
            }
            if (node.val == p.val || node.val == q.val) {
                count ++;
            }
            if (solution == null && count + left + right == 2) {
                solution = node;
                return 2;
            }
            return count + left + right;
        }
    }
}
