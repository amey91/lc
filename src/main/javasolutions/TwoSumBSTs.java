package javasolutions;

import java.util.HashSet;
import java.util.Set;

import javasolutions.commons.TreeNode;

public class TwoSumBSTs {


// 1. this stores all values in first tree and then iterates second tree with that information to see if we have a node in first tree that match nodes in the seconds one
// time = N+M where N,M are number of nodes in both tree; space = N

// 2. there is another solution where we iterate first tree and for every node in first, we try to find a node in the second one
// time = N*logM; space = 2


//    https://leetcode.com/problems/two-sum-bsts/
//    1214. Two Sum BSTs
    class Solution {
        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            if (root1 == null || root2 == null) {
                return false;
            }

            Set<Integer> seen = new HashSet<>();
            collectValues(root1, seen);

            return iterate(root2, seen, target);

        }

        private boolean iterate(TreeNode node, Set<Integer> seen, int target) {
            if (node == null) {
                return false;
            }

            if (seen.contains(target - node.val)) {
                return true;
            }

            return iterate(node.left, seen, target) || iterate(node.right, seen, target);
        }

        private void collectValues(TreeNode node, Set<Integer> seen) {
            if (node == null) {
                return;
            }

            seen.add(node.val);
            collectValues(node.left, seen);
            collectValues(node.right, seen);
        }
    }
}
