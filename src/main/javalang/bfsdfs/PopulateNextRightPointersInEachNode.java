package javalang.bfsdfs;

public class PopulateNextRightPointersInEachNode {
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


// 116. Populating Next Right Pointers in Each Node
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

    // naive approach is to do BFS and keep populating next pointers based on queue
// optimized approach is iterative and we manipulate level (N+1) when we are at level N
// this when we reach a new level, all the next pointers for that level are already set
    // time = N
    // space = 1
    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            Node left = root;

            Node currNode;

            // inter-level loop
            while (left != null) { // 2
                currNode = left;

                // intra-level loop
                while (currNode != null) { // 3

                    // systematically check each other node we want to tal to, first if left node and the second is next node
                    if (currNode.left != null) {
                        currNode.left.next = currNode.right;

                        if (currNode.next != null) {
                            currNode.right.next = currNode.next.left;
                        }
                    } /* else {// optimization: since tree is perfect tree and we have reached last level and the pointers for this level are already set, we can return;
                return root; } */

                    // always increment currNode
                    currNode = currNode.next;
                }

                // always increment left
                left = left.left;
            }

            return root;

        }


        // Approach 1: non-optimal BFS solution with N space
//     public class BfsNode {
//         Node node;
//         int level;

//         public BfsNode(Node node, int level) {
//             this.node = node;
//             this.level = level;
//         }
//     }


//     public Node connect(Node root) {
//         // do bfs
//         // if bfs queue is not empty and there is a node in the queue at the same level, then that is the next node; else next = null


//         if (root == null) {
//             return null;
//         }

//         Queue<BfsNode> queue = new ArrayDeque<>();
//         queue.offer(new BfsNode(root, 1));

//         while (!queue.isEmpty()) {
//             BfsNode currNode = queue.poll();

//             if (queue.isEmpty()) {
//                 currNode.node.next = null;
//             } else if (queue.peek().level != currNode.level) {
//                 currNode.node.next = null;
//             } else {
//                 currNode.node.next = queue.peek().node;
//             }

//             if (currNode.node.left != null) {
//                 queue.offer(new BfsNode(currNode.node.left, currNode.level + 1));
//             }
//             if (currNode.node.right != null) {
//                 queue.offer(new BfsNode(currNode.node.right, currNode.level + 1));
//             }
//         }

//         return root;
//     }
    }
}
