import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;



/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        ArrayList<TreeNode> bfs = new ArrayList<>();
        bfs.add(root);
        return minDepthByBFS(bfs, 1);
    }
    
    private int minDepthByBFS(List<TreeNode> nodes, int currDepth){
        ArrayList<TreeNode> newNodes = new ArrayList<>();
        for(TreeNode node: nodes){
            if(node.left==null && node.right==null)
                return currDepth;
            if(node.left!=null)
                newNodes.add(node.left);
            if(node.right!=null)
                newNodes.add(node.right);
        }
        
        return minDepthByBFS(newNodes, currDepth+1);
    }
}