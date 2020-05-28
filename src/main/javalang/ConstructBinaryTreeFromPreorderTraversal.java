package javalang;

import java.util.LinkedList;
import java.util.List;

import javalang.commons.TreeNode;

// pass up and pass down a value
// if that value is -1 then just keep going
// else value += 1
// if at any point value == K then add to answer and pass this value up/down
// if node.val == target, then pass up/down 0

public class ConstructBinaryTreeFromPreorderTraversal {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> list = new LinkedList<>();
        if (root == null || K < 0) {
            return list;
        }

        kDistanceHelper(root, target, K, -1 /*currentVal*/, list);
        return list;
    }


    private int kDistanceHelper(TreeNode node, TreeNode target, int K, int currentVal, List<Integer> result) { // node=3, target=5, k=2, currentVal=-1
        if (node == null) {
            return -1;
        }

        // top down
        if (node == target) {
            currentVal = 0;
        } else if (currentVal >= 0) {
            currentVal += 1;
        }

        if (currentVal == K) {
            result.add(node.val);
        } else if (currentVal > K) {
            return -1;
        }

        // pass top down values to nodes below
        int leftDist = kDistanceHelper(node.left, target, K, currentVal, result);

        int rightDist = kDistanceHelper(node.right, target, K, currentVal, result);

        int bottomUpDist = Math.max(leftDist, rightDist);

        // if bottom up results contain node, then process it
        if (bottomUpDist >= 0) {
            bottomUpDist++;
            if (bottomUpDist == K) {
                result.add(node.val);
            }
            if (leftDist >= 0) {
                // if node was in left subtree, there might be nodes at distance K in right subtree
                kDistanceHelper(node.right, target, K, bottomUpDist, result);
            } else {
                // if node was in right subtree, there might be nodes at distance K in left subtree
                kDistanceHelper(node.left, target, K, bottomUpDist, result);
            }
        }

        // dont care about currentVal (topDown value) while returning
        if (node == target) {
            return 0;
        } else {
            return bottomUpDist;
        }
    }
}