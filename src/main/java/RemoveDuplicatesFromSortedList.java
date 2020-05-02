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
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode current = head;
        ListNode previous = head;
        current = current.next;
        while(current!=null){
            if(current.val==previous.val){
                previous.next=current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }
        return head;
    }
}