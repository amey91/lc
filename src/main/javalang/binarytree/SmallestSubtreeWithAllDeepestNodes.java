package javalang.binarytree;

import javalang.commons.TreeNode;

public class SmallestSubtreeWithAllDeepestNodes {
    // 865. Smallest Subtree with all the Deepest Nodes
// https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
    class Solution {

        class DfsNode {
            int height;
            TreeNode node;

            public DfsNode(int h, TreeNode node) {
                this.height = h;
                this.node = node;
            }
        }

        // parses the tree and once at leaf node, will return the current hieght
        // for every node, we compare height from left and right nodes, and return the greater of those
        // time = N
        // space = N (recursion and making new object at each node)
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            if (root == null) {
                return root;
            }
            DfsNode deepest = getDfsNode(root, 1);
            return deepest.node;
        }

        private DfsNode getDfsNode(TreeNode node, int currHeight) {

            if (node.left == null && node.right == null) {
                return new DfsNode(currHeight, node);
            }

            if (node.left == null) {
                return getDfsNode(node.right, currHeight + 1);
            }
            if (node.right == null) {
                return getDfsNode(node.left, currHeight + 1);
            }

            DfsNode left = getDfsNode(node.left, currHeight + 1);
            DfsNode right = getDfsNode(node.right, currHeight + 1);

            if (right.height == left.height) {
                return new DfsNode(right.height, node);
            }

            if (left.height > right.height) {
                return left;
            }
            return right;
        }
    }
}
