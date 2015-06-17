import commons.ListNode;

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
public class AddTwoNumbers {
    public ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        if(l1==null && l2==null)
            return null;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        int currVal = l1.val + l2.val;
        int carry = currVal/10;
        currVal = currVal%10;
        ListNode<Integer> head = new ListNode(currVal);
        ListNode<Integer> temp = head;
        l1=l1.next;
        l2=l2.next;
        while(l1!=null && l2!=null){
            currVal = l1.val + l2.val+carry;
            carry = currVal/10;
            currVal = currVal%10;
            temp.next = new ListNode(currVal);
            temp = temp.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            currVal = l1.val+carry;
            carry = currVal/10;
            currVal = currVal%10;
            temp.next = new ListNode(currVal);
            temp = temp.next;
            l1=l1.next;
        }
        while(l2!=null){
            currVal = l2.val+carry;
            carry = currVal/10;
            currVal = currVal%10;
            temp.next = new ListNode(currVal);
            temp = temp.next;
            l2=l2.next;
        }
        if(carry>0)
            temp.next = new ListNode(carry);
        return head;
    }
}