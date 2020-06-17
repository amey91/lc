package javalang.binarytree;

import java.util.HashMap;
import java.util.Map;

import javalang.commons.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversals {
    // 106. Construct Binary Tree from Inorder and Postorder Traversal
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

    class Solution {

        // process array so that we locate root from postorder and then find the left and right subtree length from inorder
        // Recursively call the routine with left and right subtrees
        // time = N
        // space = N
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            // algo
            // post order last is the root
            // find root in inorder
            // right of root is right subtree
            // rootIndex-1 is rightstubtree root
            // rootIndex - 1 - (rightSubtreeLEngh) = start of left subtree

            if (inorder == null) {
                return null;
            }


            // stores
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return tree(inorder, 0, inorder.length - 1, postorder, postorder.length - 1, map);
        }

        private TreeNode tree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, Map<Integer, Integer> map) {

            // we can easily derive these from recursive call below. Idally you can one shot these conditions
            if (inStart > inEnd || inEnd < 0 || postStart < 0 || inStart >= inorder.length) {
                return null;
            }

            if (inStart == inEnd) {
                return new TreeNode(inorder[inStart]);
            }

            int rootValue = postorder[postStart];

            int rootInorderIndex = map.get(rootValue); // 1

            // length of right subtree
            int leftRootOffset = inEnd - rootInorderIndex; // 1

            TreeNode root = new TreeNode(rootValue);
            root.left = tree(inorder, inStart, rootInorderIndex - 1, postorder, postStart - 1 - leftRootOffset, map);
            root.right = tree(inorder, rootInorderIndex + 1, inEnd, postorder, postStart - 1, map);
            return root;
        }
    }
}
