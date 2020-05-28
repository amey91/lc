package javalang;

import javalang.commons.TreeNode;

public class ConstructBinaryTreeFromPreorderTraversal {

    // 1008. Construct Binary Search Tree from Preorder Traversal
// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

    // Divide and conquer
    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            return helper(preorder, 0, preorder.length - 1);
        }

        private TreeNode helper(int[] arr, int left, int right) {
            if (left > right) {
                return null;
            }
            if (left == right) {
                return new TreeNode(arr[left]);
            }

            TreeNode node = new TreeNode(arr[left]);
            Integer smaller = null;
            for (int i = left + 1; i <= right && arr[i] < arr[left]; i++) {
                smaller = i;
            }
            if (smaller == null) {
                // if smaller is not present then consider all of them as larger
                node.left = null;
                node.right = helper(arr, left + 1, right);
            } else {
                // if smaller present then divide and conquer
                node.left = helper(arr, left + 1, smaller);
                node.right = helper(arr, smaller + 1, right);
            }
            return node;
        }
    }
}