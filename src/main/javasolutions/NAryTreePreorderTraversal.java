package javasolutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javasolutions.commons.Node;

public class NAryTreePreorderTraversal {
    // https://leetcode.com/problems/n-ary-tree-preorder-traversal/submissions/
    // 589. N-ary Tree Preorder Traversal
    class Solution {
        public List<Integer> preorder(Node root) {
            if (root == null) {
                return new ArrayList<>();
            }

            Deque<Node> stack = new ArrayDeque<>();
            List<Integer> result = new ArrayList<>();
            stack.offerLast(root);

            while (!stack.isEmpty()) {
                Node curr = stack.pollLast();
                result.add(curr.val);
                for (int i = curr.children.size() - 1; i >= 0; i--) {
                    stack.offerLast(curr.children.get(i));
                }
            }
            return result;
        }

        public List<Integer> preorder_recursive(Node root) {
            List<Integer> result = new ArrayList<>();

            preOrderTraversal(root, result);
            return result;
        }

        private void preOrderTraversal(Node node, List<Integer> result) {
            if (node == null) {
                return;
            }
            result.add(node.val);
            for (Node node_ : node.children) {
                preOrderTraversal(node_, result);
            }
        }
    }
}
