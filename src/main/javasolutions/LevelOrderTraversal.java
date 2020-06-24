package javasolutions;

import javasolutions.commons.TreeNode;

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
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        ArrayList<Integer> tempList = new ArrayList<>();
        tempList.add(root.val);
        list.add(tempList);
        
        if(root.left==null && root.right==null)
            return list;
        
        //to hold nodes in current level
        ArrayList<TreeNode> levelNodes = new ArrayList<>();
        levelNodes.add(root); 
        
        while(levelNodes.size()>0){
            ArrayList<TreeNode> tempLevelNodes = new ArrayList<>();
            for(TreeNode t: levelNodes){
                if(t.left!=null)
                    tempLevelNodes.add(t.left);
                if(t.right!=null)
                    tempLevelNodes.add(t.right);
            }
            tempList = new ArrayList<>();
            for(TreeNode t : tempLevelNodes)
                tempList.add(t.val);
            if(tempList.size()>0)
                list.add(tempList);
            levelNodes = tempLevelNodes;
        }
        return list;
    }
}