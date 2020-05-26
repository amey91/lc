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
public class FlattenBinaryTreeToLinkedList {
    
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        if(root.right==null && root.left==null){
            return;
        }
        if(root.left==null){
            flatten(root.right);
            return;  
        } 
        else if(root.right==null){
            root.right= root.left;
            root.left = null;
            flatten(root.right);
            return;
        }
        flatten(root.right);
        flatten(root.left);
        // merge the flattened left and right parts
        TreeNode temp = root.right;
        TreeNode last = rightMostNode(root.left);
        root.right=root.left;
        root.left=null;
        last.right=temp;        
    }

    private TreeNode rightMostNode(TreeNode node){
        if(node==null)
            return null;
        while(node.right!=null)
            node=node.right;
        return node;
    }
}