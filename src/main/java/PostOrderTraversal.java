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
public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        return traverseTree(root, ans);
    }
    
    public List<Integer> traverseTree(TreeNode root, List<Integer> list){
        if(root==null)
            return list;
        traverseTree(root.left, list);
        traverseTree(root.right, list);
        list.add(root.val);
        return list;
    }
}