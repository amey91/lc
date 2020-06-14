package javalang.binarytree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javalang.commons.TreeNode;

public class DeleteNodesAndReturnForest {
    // 1110. Delete Nodes And Return Forest
// https://leetcode.com/problems/delete-nodes-and-return-forest/

    class Solution {

        // I have coded this approach to be TOP-DOWN where the information whethter parent node was deleted or not is
        // passsed down from top to bottom and each node decides for itself what its set of actions are
        // time = N space = N
        // IMPORTANT: This can be simplified by going BOTTOM-UP where a node decides whether its value w.r.t parent should be itself or null. This unlocks the true potential for recursion for this solution!!! REF: https://leetcode.com/problems/delete-nodes-and-return-forest/discuss/328860/Simple-Java-Sol
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> result = new ArrayList<>();
            Set<Integer> toDelete = new HashSet<>();
            for (int d : to_delete) {
                toDelete.add(d);
            }
            divideTree(root, toDelete, result, true);
            return result;
        }

        private void divideTree(TreeNode node, Set<Integer> toDelete, List<TreeNode> result, boolean isParentDeleted) {

            if (node == null) {
                return;
            }

            // delete current
            if (toDelete.contains(node.val)) {
                divideTree(node.left, toDelete, result, true);
                node.left = null;

                divideTree(node.right, toDelete, result, true);
                node.right = null;
                return;
            }

            if (isParentDeleted) {
                result.add(node);
            }

            if (node.left != null && toDelete.contains(node.left.val)) {
                TreeNode temp = node.left;
                node.left = null;
                divideTree(temp, toDelete, result, false);
            }

            if (node.right != null && toDelete.contains(node.right.val)) {
                TreeNode temp = node.right;
                node.right = null;
                divideTree(temp, toDelete, result, false);
            }

            divideTree(node.right, toDelete, result, false);
            divideTree(node.left, toDelete, result, false);
        }
    }
}
