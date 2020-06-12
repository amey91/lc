package javalang;

import javalang.commons.TreeNode;

public class ClosestBinarySearchTreeValue {
    // 270. Closest Binary Search Tree Value
// https://leetcode.com/problems/closest-binary-search-tree-value/

    // find closest in bst by choosing correct branch. We can go to both branhces, but this is more efficient and gives logn time
    class Solution {

        // time = logn
        // space = 1
        public int closestValue(TreeNode root, double target) {
            int answer = root.val;
            while (root != null) {
                if (Math.abs(root.val - target) < Math.abs(answer - target)) {
                    answer = root.val;
                }

                if (root.val > target) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return answer;
        }


        // time = logn
        // space = logn for recursion stack
//     public int closestValue_recursive(TreeNode root, double target) {
//         if (root.val == target) {
//             return root.val;
//         }

//         int min = root.val;

//         if (target  < root.val) {
//             if (root.left != null) {
//                 int left = closestValue(root.left, target);
//                 if (Math.abs(left - target) < Math.abs(min - target)) {
//                     min = left;
//                 }
//             }
//         } else {
//             if (root.right != null) {
//                 int right = closestValue(root.right, target);
//                 if (Math.abs(right - target) < Math.abs(min - target)) {
//                     min = right;
//                 }
//             }
//         }
//         return min;
//     }
    }
}
