package javalang.bfsdfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javalang.commons.TreeNode;

public class RightViewOfTree {

    // 199. Binary Tree Right Side View
// https://leetcode.com/problems/binary-tree-right-side-view/


    // we iterate tree in BFS and record the value of last node at every level!
    class Solution {

        class Node {
            TreeNode node;
            int level;

            public Node(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }
        }

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            // maps level to last value on that node. We can eliminate this by comparing the levels with the size of result list
            Map<Integer, Integer> counts = new HashMap<>();
            Deque<Node> bfs = new ArrayDeque<>();
            if (root == null) {
                return result;
            }

            bfs.offer(new Node(root, 1));
            int maxLevel = 1;

            while (!bfs.isEmpty()) {
                Node node = bfs.poll();

                // always update the position for this level since it is BFS
                counts.put(node.level, node.node.val);

                if (node.node.left != null) {
                    bfs.offer(new Node(node.node.left, node.level + 1));
                }
                if (node.node.right != null) {
                    bfs.offer(new Node(node.node.right, node.level + 1));
                }
                maxLevel = node.level;
            }

            for (int i = 1; i <= maxLevel; i++) {
                result.add(counts.get(i));
            }
            return result;
        }
    }
}
