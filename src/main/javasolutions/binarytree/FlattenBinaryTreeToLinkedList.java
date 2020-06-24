package javasolutions.binarytree;

import javasolutions.commons.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTreeToLinkedList {


    class Solution {

        // algo: each recursive call returns the tail of the flattened tree (which is rightTail if right side was present or it is lefttail)
        public void flatten(TreeNode root) {
            flattenInternal(root);
        }

        private TreeNode flattenInternal(TreeNode node) {
            if (node == null) {
                return null;
            }
            if (node.right == null && node.left == null) {
                return node;
            }

            TreeNode rightTail = flattenInternal(node.right);
            TreeNode leftTail = flattenInternal(node.left);

            if (leftTail == null) {
                return rightTail;
            }

            // rearrange nodes for moving left subtree to right
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = null;
            leftTail.right = temp;

            // return correct tail from both subtrees
            return rightTail == null ? leftTail : rightTail;
        }
    }
}