package javalang.binarysearch;

import java.util.HashSet;
import java.util.Set;

import javalang.commons.TreeNode;

public class TwoSum4InputIsABST {
    // 653. Two Sum IV - Input is a BST
// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

// 1. time = N space = N by iterating over all array at most once and conparing recently seen ones
// 2. other methods include doing inorder traveral then doing 2Sum using 2 pointer since array will be sorted
// 3. Another method is NlogN time and logn space (logn = h = height of tree). For each node, we see it its complementary node is in BST, starting from root

    class Solution {

        public boolean findTarget_recursive(TreeNode root, int k) {
            if (root == null) {
                return false;
            }

            Set<Integer> seen = new HashSet<>();
            return iterateTree(root, k, seen);
        }

        private boolean iterateTree(TreeNode node, int k, Set<Integer> seen) {
            if (node == null) {
                return false;
            }

            if (seen.contains(k - node.val)) {
                return true;
            }
            seen.add(node.val);

            return iterateTree(node.left, k, seen) || iterateTree(node.right, k, seen);
        }
    }
}
