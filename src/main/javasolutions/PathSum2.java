package javasolutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javasolutions.commons.TreeNode;

public class PathSum2 {


// 113. Path Sum II
// https://leetcode.com/problems/path-sum-ii/

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> answer = new ArrayList<>();

            if (root == null) {
                return answer;
            }
            List<Integer> currList = new LinkedList<>();
            parseTree(root, sum, currList, answer);
            return answer;
        }

        private void parseTree(TreeNode node, int sum, List<Integer> currList, List<List<Integer>> result) {

            if (node == null) {
                return;
            }

            currList.add(node.val);
            sum -= node.val;

            if (node.left == null && node.right == null) {
                if (sum == 0) {
                    result.add(new ArrayList<>(currList));
                }
                currList.remove(currList.size() - 1);
                return;
            }

            parseTree(node.left, sum, currList, result);
            parseTree(node.right, sum, currList, result);
            currList.remove(currList.size() - 1);
        }
    }
}
