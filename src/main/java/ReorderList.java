package main.java;

import main.java.commons.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode mid = splitListIntoHalf(head);
        mid = reverseList(mid);
        mergeLists(head, mid);    
    }
    
    private static ListNode splitListIntoHalf(ListNode head){
        if(head==null)
            return head;
        ListNode fast, slow;
        slow = head;
        fast = head.next;
        while(fast!=null){
            slow = slow.next;
            if(fast.next==null)
                break;
            fast = fast.next.next;
        }
        ListNode temp = slow;
        slow = slow.next;
        temp.next = null;
        return slow;
    }
    
    private static ListNode reverseList(ListNode head){
        if(head==null)
            return head;    
        // pre-in-post -> post-in-pre
        ListNode pre = head;
        ListNode in = pre.next;
        ListNode post;
        pre.next=null;
        while(in!=null){
            post = in.next;
            in.next = pre;
            pre = in;
            in = post;
        }
        return pre;
    }
    
    private static ListNode mergeLists(ListNode head1, ListNode head2){
        ListNode ret = head1;
        if(head1==null || head2==null){
            ret = head1==null? head2:head1;
            return ret;
        }
        ListNode temp1, temp2;
        while(head1!=null && head2!=null){
            temp1 = head1.next;
            temp2 = head2.next;
            head1.next = head2;
            head2.next = temp1;
            head1 = temp1;
            head2 = temp2;
        }
        return ret;
    }
}