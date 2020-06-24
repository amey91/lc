package javasolutions.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javasolutions.commons.TreeNode;

public class BinaryTreePreorderTraversal {

    // 144. Binary Tree Preorder Traversal
// https://leetcode.com/problems/binary-tree-preorder-traversal/
    class Solution {

        // Keep going till either stack has values or curr node is not null
        // Only 1 line changes between iterative preorder and inorder traversals
        // In interview, solve base case first for 3 nodes, solution for everything else just follows
        public List<Integer> preorderTraversal(TreeNode root) {

            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root == null) {
                    root = stack.pop();
                    root = root.right;
                } else {
                    result.add(root.val);
                    stack.add(root);
                    root = root.left;
                }
            }

            return result;
        }
    }

}
