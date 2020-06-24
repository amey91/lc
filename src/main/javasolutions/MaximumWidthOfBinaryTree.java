package javasolutions;

import java.util.ArrayDeque;
import java.util.Queue;

import javasolutions.commons.TreeNode;

public class MaximumWidthOfBinaryTree {
    // https://leetcode.com/problems/maximum-width-of-binary-tree/submissions/
// 662. Maximum Width of Binary Tree

    // we iterate in BFS and pass down the position of each node w.r.t. the entire tree
    class Solution {
        class Node {
            TreeNode node;
            int height;
            int pos;

            public Node(TreeNode node, int height, int pos) {
                this.node = node;
                this.height = height;
                this.pos = pos;
            }
        }

        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int currHeight = 0;
            int width = 1;
            int maxWidth = 1;
            int left = 1;
            Queue<Node> queue = new ArrayDeque<>();

            queue.add(new Node(root, currHeight, 1));

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                if (node.height != currHeight) {
                    currHeight = node.height;
                    width = 1;
                    left = node.pos;
                } else {
                    width = node.pos - left + 1;
                }
                if (node.node.left != null) {
                    queue.add(new Node(node.node.left, node.height + 1, node.pos * 2));
                }
                if (node.node.right != null) {
                    queue.add(new Node(node.node.right, node.height + 1, node.pos * 2 + 1));
                }

                maxWidth = Math.max(width, maxWidth);

            }

            return maxWidth;
        }
    }
}
