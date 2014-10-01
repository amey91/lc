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
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        return isBinaryNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE); 
    }
    
    private boolean isBinaryNode(TreeNode node, int min, int max){
        if(node==null)
            return true;
            
        if(node.val>=max || node.val<=min)
            return false;
        // WTH, I was not checking values for all non-leaf nodes! :| 
        // if(node.left==null && node.right==null)
        //     return min<node.val && max>node.val;
        
        return isBinaryNode(node.left, min, node.val) 
            && isBinaryNode(node.right, node.val, max);

    }

}