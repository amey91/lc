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
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        
        if(isSameNode(p,q))
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else return false;
        
    }
    
    private boolean isSameNode(TreeNode p, TreeNode q){
        return p.val==q.val;
    }
}