package javalang;

import javalang.commons.TreeNode;


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return checkForSymmetry(root.left, root.right);
    }

    private boolean checkForSymmetry(TreeNode left, TreeNode right){
        if(left==null && right==null)
            return true;
            
        if(left==null || right==null)
            return false;
            
        if(left.val==right.val)
            return checkForSymmetry(left.right, right.left) && checkForSymmetry(left.left, right.right);
        return false;
    }
}