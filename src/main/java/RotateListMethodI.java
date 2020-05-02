package main.java;

import main.java.commons.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RotateListMethodI  {
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null || head.next==null || n==0)
            return head;
        ListNode temp;
        int count=n;
        while(count>0){
            temp=head;
            while(temp.next.next!=null){
                temp=temp.next;
            }
            temp.next.next=head;
            head=temp.next;
            temp.next=null;
            count--;
        }
        return head;
    }
}