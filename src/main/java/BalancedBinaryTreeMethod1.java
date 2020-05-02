package main.java;


import main.java.commons.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTreeMethod1 {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        if(Math.abs(height(root.left,0)-height(root.right,0))<2)
            return isBalanced(root.left) && isBalanced(root.right);
        return false;
    
    }
    
    private int height(TreeNode node, int height){
        if(node==null)
            return height;
        return Math.max(height(node.left, height+1), height(node.right, height+1));
    }
}