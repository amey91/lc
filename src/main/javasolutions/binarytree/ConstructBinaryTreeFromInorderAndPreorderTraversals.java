package javasolutions.binarytree;

import javasolutions.commons.TreeNode;

public class ConstructBinaryTreeFromInorderAndPreorderTraversals {
    // 105. Construct Binary Tree from Preorder and Inorder Traversal
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    class Solution {

        // look up current root from preorder and process left and right subtrees from  inorder traversal using that index
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // algo:
            // First node in preorder is root
            // Find index of root in inOrder traversal. Everything to left of that is in left subtree and same for right
            // While setting next bounds for inorder traversal, we pass bounds of current array
            // While setting bounds for preorder traversal, we only need the root of current tree/subtree, so only 1 pointer is enough

            return constructTree(preorder, 0, inorder, 0, inorder.length - 1);
        }

        private TreeNode constructTree(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {

            if (preStart >= preorder.length  // derived from the limits below
                        || inStart >= inorder.length // derived from the limits below
                        || inEnd < 0 // derived from the limits below
                        || inEnd < inStart // for left window, during (inStart, inorderRootIndex - 1) the left index can go out of current window
            ) {
                return null;
            }

            if (inStart == inEnd) {
                return new TreeNode(inorder[inStart]);
            }

            int currentRoot = preorder[preStart];

            // TODO: look up indexes from a map that stores value -> index to get N time
            int inorderRootIndex = findIndex(inorder, currentRoot);

            // this is the length of the left subtree. We skip these many nodes in preorder traversal to locate the right subtree root.
            int preorderOffset = inorderRootIndex - inStart;

            TreeNode root = new TreeNode(currentRoot);
            root.left = constructTree(preorder, preStart + 1, inorder, inStart, inorderRootIndex - 1);
            root.right = constructTree(preorder, preStart + 1 + preorderOffset, inorder, inorderRootIndex + 1, inEnd);

            return root;
        }


        // IMPORTANT: this complexity can be reduced to constant time by storing indices of each element in a hashmap and looking up in 1 time and N space. Keeping this the same for readability
        private int findIndex(int[] nums, int n) {

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == n) {
                    return i;
                }
            }

            return -1;
        }
    }

}
