package javasolutions;

import javasolutions.commons.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        if(root.right==null && root.left==null && sum==root.val)
            return true;
        return parseTree(root, sum, 0);
    }
    
    private boolean parseTree(TreeNode node, int sum, int currSum){
        if(node==null)
            return false;
        currSum += node.val;
        if(node.left==null && node.right==null && sum==currSum)
            return true;
        return parseTree(node.right, sum, currSum) 
                    || parseTree(node.left, sum, currSum);
    }
}