package javasolutions.bfsdfs;

public class PopulateNextRightPointersInEachNode2 {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

//    117. Populating Next Right Pointers in Each Node II
//    https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
    class Solution {

        // IMPORTANT: the most elegant solution SOURCE == https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37811/Simple-solution-using-constant-space
        // recurse through each level. Place a temporary node at the beginninng of N+1 level. When finished processing N level, start new level using currNode = temporary.next
        public Node connect(Node root) {
            Node currNode = root;

            while (currNode != null) {
                // our placeholder
                Node tempChild = new Node(0);
                Node currentChild = tempChild;

                // process full level
                while (currNode != null) {
                    // currChild is always last known valid child
                    if (currNode.left != null) {
                        currentChild.next = currNode.left;
                        currentChild = currentChild.next;
                    }
                    if (currNode.right != null) {
                        currentChild.next = currNode.right;
                        currentChild = currentChild.next;
                    }
                    // move within the same level
                    currNode = currNode.next;
                }

                // Proceed to next level. This points to anything that our placeholder is pointing to
                currNode = tempChild.next;
            }
            return root;
        }


        // My solution 2: this is recursive version, but please refer to the above solution, this is shit compared to that
        // this solution reduces complexity for Solution 1 by removing an iterative loop and replacing it with recursive call, not that much of an improvement IMHO, did it just for the sake of it
//         public Node connect1(Node root) {
//             // IMPORTANT: dont check (root.right == null && root.left == null) in this condition otherwise we will not handle case where left child has no children but then we want to process
//             // right child anyways since it has nodes e.g. [3,9,20,null,null,15,7], we dont want to stop at 9
//             if (root == null ) {
//                 return root;
//             }

//             int val = root.val;
//             Node currNode = root;
//             while (currNode != null) {

//                 Node rightNodeThatHasChild = currNode.next;

//                 while (rightNodeThatHasChild != null && rightNodeThatHasChild.left == null && rightNodeThatHasChild.right == null) {
//                     rightNodeThatHasChild = rightNodeThatHasChild.next;
//                 }

//                 if (currNode.left != null) {
//                     if (currNode.right != null) {
//                         currNode.left.next = currNode.right;
//                     } else {
//                         currNode.left.next = rightNodeThatHasChild == null ? null : rightNodeThatHasChild.left == null ? rightNodeThatHasChild.right : rightNodeThatHasChild. left;
//                     }
//                 }

//                 if (currNode.right != null) {
//                     currNode.right.next = rightNodeThatHasChild == null ? null : rightNodeThatHasChild.left == null ? rightNodeThatHasChild.right : rightNodeThatHasChild. left;
//                 }

//                 currNode = currNode.next;
//             }

//             Node next = root.left != null? root.left : root.right != null? root.right : root.next;
//             connect(next);
//             return root;
//         }

//     // we recurse through each level. When we are in N level, we fill next pointers for N+1 level.
//     // for each node, the next pointers for children at N+1 level are found  from the next right node at level N that has children
//     // for the next node we want tot start with, it can either be currNode.left or currNode.right or currNode.next in that order!
//     // time = N
//     // space = 1
//     public Node connect_iterative_solution(Node root) {
//         if (root == null) return null;

//         Node left = root;

//         // inter level loop
//         while (left != null) {
//             Node currNode = left;

//             // intra level loop
//             while (currNode != null) {

//                 Node rightNodeWithChild = currNode.next;


//                 // loop to find next valid child
//                 while (rightNodeWithChild != null && rightNodeWithChild.left == null && rightNodeWithChild.right == null) {
//                         rightNodeWithChild = rightNodeWithChild.next;
//                 }

//                 // currNode.left.next should be currNode.right or child of rightNodeWithChild
//                 if (currNode.left != null) {
//                     if (currNode.right != null) {
//                         currNode.left.next = currNode.right;
//                     } else {
//                         currNode.left.next = rightNodeWithChild == null ? null : rightNodeWithChild.left == null ? rightNodeWithChild.right : rightNodeWithChild.left;
//                     }
//                 }

//                 // currNode.right should be child of rightNodeWithChild
//                 if (currNode.right != null) {
//                     currNode.right.next = rightNodeWithChild == null ? null : rightNodeWithChild.left == null ? rightNodeWithChild.right : rightNodeWithChild.left;
//                 }

//                 // move curr node to node within same level that has next children
//                 currNode = rightNodeWithChild;
//             }


//             // left should go to left.left or left.right or left.next, first of whichever is not null
//             left = left.left == null && left.right == null ? left.next: left.left == null? left.right : left.left;
//         }

//         return root;
//     }
    }
}
