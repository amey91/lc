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
public class SumRootToLeafNumbersInefficient {
    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return parseTreeForSum(root, sb);
    }
    
    private int parseTreeForSum(TreeNode root, StringBuilder sb){
        if(root==null)
            return 0;
        sb.append(String.valueOf(root.val));
        // if leaf node
        if(root.left==null && root.right==null)
            return getSumFromStringBuilder(sb);
        // solution not good.. new stringbuilders built at each step! 
        // because I dont want to share the same stringbuilder for all leaf nodes
        int leftSum = parseTreeForSum(root.left, new StringBuilder(sb));
        int rightSum = parseTreeForSum(root.right, new StringBuilder(sb));
        return leftSum+rightSum;
    }
    
    private int getSumFromStringBuilder(StringBuilder sb){
        char[] c = sb.toString().toCharArray();
        int sum=0;
        for(int i=0; i<c.length; i++)
            sum = sum*10 + Character.getNumericValue(c[i]);
        return sum;
    }
}