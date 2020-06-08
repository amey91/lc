package javalang.binarysearch;

import javalang.commons.TreeNode;


// similar to inorderSuccessor

// predecessor is largest node that is smaller than target value
public class InorderPredecessorInBST {
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        while (root != null) {
            if (root.val < p.val) {
                pre = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return pre;
    }
}
