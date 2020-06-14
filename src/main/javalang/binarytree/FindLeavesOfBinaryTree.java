package javalang.binarytree;

import java.util.ArrayList;
import java.util.List;

import javalang.commons.TreeNode;

public class FindLeavesOfBinaryTree {
    // 366. Find Leaves of Binary Tree
// https://leetcode.com/problems/find-leaves-of-binary-tree/

    class Solution {

        // we traverse tree and pass the level from leaf nodes
        // each level corresponds to a layer in result
        // for each node, it take max level from either children to assign it correct level
        // time = N
        // space = N
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            populateLevel(root, result);

            return result;
        }

        private int populateLevel(TreeNode node, List<List<Integer>> result) {

            if (node == null) {
                return 0;
            }

            if (node.left == null && node.right == null) {
                if (result.isEmpty()) {
                    result.add(new ArrayList<>());
                }

                result.get(0).add(node.val);
                return 0;
            }

            int left = populateLevel(node.left, result);
            int right = populateLevel(node.right, result);

            int max = Math.max(left, right);
            int level = max + 1;

            while (result.size() <= level) {
                result.add(new ArrayList<>());
            }

            result.get(level).add(node.val);

            return level;
        }
    }
}
