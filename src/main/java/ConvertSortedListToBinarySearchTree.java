package main.java;

import main.java.commons.ListNode;
import main.java.commons.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return new TreeNode(head.val);

        List<TreeNode> answer = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            answer.add(new TreeNode(temp.val));
            temp=temp.next;
        }
        return arrayListToBinarySearchTree(answer, 0, answer.size()-1);
    }

    private TreeNode arrayListToBinarySearchTree(List<TreeNode> list, int start, int end){
        if(start>end || start<0 || end>=list.size())
            return null;
        int mid = (start+end)/2;
        TreeNode temp = list.get(mid);
        temp.left=arrayListToBinarySearchTree(list, start, mid-1);
        temp.right=arrayListToBinarySearchTree(list, mid+1, end);
        return temp;

    }
}