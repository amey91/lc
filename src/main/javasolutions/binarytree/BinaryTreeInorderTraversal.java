package javasolutions.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javasolutions.commons.TreeNode;

public class BinaryTreeInorderTraversal {

    // https://leetcode.com/problems/binary-tree-inorder-traversal/
// 94. Binary Tree Inorder Traversal

    class Solution {

        // Keep going till either stack has values or curr node is not null
        // Only 1 line changes between iterative preorder and inorder traversals
        // In interview, solve base case first for 3 nodes, solution for everything else just follows
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root == null) {
                    root = stack.pop();
                    result.add(root.val);
                    root = root.right;
                } else {
                    stack.add(root);
                    root = root.left;
                }
            }

            return result;
        }
    }
}
