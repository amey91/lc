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
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length==0)
            return null;
        if(num.length==1)
            return new TreeNode(num[0]);
        return buildHeightBalancedTree(num, 0, num.length-1);
    }

    private TreeNode buildHeightBalancedTree(int[] num, int start, int end){
        if(end<start || start<0 || end>=num.length)
            return null;
        if(end==start)
            return new TreeNode(num[start]);
        
        int mid = (start+end)/2;
        TreeNode temp = new TreeNode(num[mid]);
        
        temp.left = buildHeightBalancedTree(num, start, mid-1);
        temp.right = buildHeightBalancedTree(num, mid+1, end);
        return temp;
    }
    
}