package leetcode;

import leetcode.commons.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return getDepth(root, 0);
    }
    
    private int getDepth(TreeNode node, int depth){
        if(node==null)
            return depth;
        if(node.right==null && node.left==null)
            return depth+1;
        return Math.max(getDepth(node.left, depth+1), getDepth(node.right, depth+1));
    }
}