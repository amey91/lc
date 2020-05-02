import main.java.commons.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(null==head) {
            return head;
        }

        if(null==head.next && n>0) {
            return null;
        }

        ListNode prev = null;
        ListNode end = head;
        ListNode start = head;

        for(int i=1; i<n; i++) {
            end=end.next;
        }

        while(end.next!=null) {
            end=end.next;
            prev=start;
            start=start.next;
        }


        if(prev==null) {
            return start.next;
        }

        prev.next=prev.next.next;

        return head;


    }

}