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
public class RotateList  {
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null || head.next==null || n==0)
            return head;
        ListNode temp = head;
        int count=0;
        // get number of nodes
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        
        int cutLength = n%count;
        if(cutLength==0)
            return head;
        
        ListNode tail = head;
        while(cutLength>0){
            tail=tail.next;
            cutLength--;
        }

        // append to start 
        temp = head;
        while(tail.next!=null){
            tail=tail.next;
            temp=temp.next;
        }
        tail.next=head;
        head=temp.next;
        temp.next=null;
        return head;
    }
}