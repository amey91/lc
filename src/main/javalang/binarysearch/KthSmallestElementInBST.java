package javalang.binarysearch;

import java.util.ArrayDeque;

import javalang.commons.TreeNode;

public class KthSmallestElementInBST {// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// 230. Kth Smallest Element in a BST

    // iterate inorder till kth index
    class Solution {
        public int kthSmallest(TreeNode root, int k) {

            ArrayDeque<TreeNode> deque = new ArrayDeque<>();

            TreeNode curr = root;
            int count = 0;

            // since K is always valid, we can keep indefinite loop. Otherwise iterate over !pq.isEmpty()
            while (true) {
                while (curr != null) {
                    deque.offer(curr);
                    curr = curr.left;
                }

                curr = deque.pollLast();
                count++;
                if (count == k) {
                    return curr.val;
                }

                curr = curr.right;
            }

        }
    }
}
