package javalang;

import javalang.commons.TreeNode;

public class RangeSumBST {
    // 938. Range Sum of BST
// https://leetcode.com/problems/range-sum-of-bst/
    class Solution {
        public int rangeSumBST(TreeNode root, int L, int R) {
            if (root == null) {
                return 0;
            }
            if (L <= root.val && root.val <= R) {
                int left = rangeSumBST(root.left, L, R);
                int right = rangeSumBST(root.right, L, R);
                return left + right + root.val;
            }
            if (root.val > R) {
                return rangeSumBST(root.left, L, R);
            }
            return rangeSumBST(root.right, L, R);
        }
    }
}
