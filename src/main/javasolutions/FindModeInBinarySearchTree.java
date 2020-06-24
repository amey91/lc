package javasolutions;

import java.util.ArrayList;
import java.util.List;

import javasolutions.commons.TreeNode;

public class FindModeInBinarySearchTree {

// NOTE: inorder traversal makes sure that all duplicates are grouped together, so
// keeping track of last value will allow us to group them without needing a map
// e.g. 1,1,2,2,2,3,4,5,6,6,7 etc.

    // time = O(n)
// space = O(1)
// 501. Find Mode in Binary Search Tree
// https://leetcode.com/problems/find-mode-in-binary-search-tree/
    class Solution {

        // current value being evaluated
        Integer currVal = null;
        int currCount = 0;
        int maxCount = 0;
        List<Integer> result = new ArrayList<>();

        public int[] findMode(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            inOrderTraversal(root);
            int[] resultArr = new int[result.size()];

            for (int i = 0; i < result.size(); i++) {
                resultArr[i] = result.get(i);
            }
            return resultArr;
        }

        private void inOrderTraversal(TreeNode node) {
            if (null == node) {
                return;
            }
            inOrderTraversal(node.left);
            if (currVal == null || currVal != node.val) {
                currVal = node.val;
                currCount = 1;
            } else {
                currCount++;
            }
            checkCurrCountAndSetAnswerIfNeeded();
            inOrderTraversal(node.right);
        }

        private void checkCurrCountAndSetAnswerIfNeeded() {
            if (currCount > maxCount) {
                maxCount = currCount;
                result.clear();
                result.add(currVal);
            } else if (currCount == maxCount) {
                result.add(currVal);
            }
        }
    }
}
