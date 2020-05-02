import main.java.commons.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /* my earlier solution used to fork strings at each non-leaf node
  * this is better because recursion case for leaf is different and returns sum
  * non-leafs return sum of leafs beneath them
  */
 
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return parseTreeForSum(root, 0);
    }
    
    private int parseTreeForSum(TreeNode root, int sumTillNow){
        if(root==null)
            return 0;
        sumTillNow = sumTillNow*10 + root.val;
        // if leaf node, return its sum
        if(root.left==null && root.right==null)
            return sumTillNow;
        // else return sum of leaf nodes beneath
        int leftSum = parseTreeForSum(root.left, sumTillNow);
        int rightSum = parseTreeForSum(root.right, sumTillNow);
        return leftSum+rightSum;
    }
}