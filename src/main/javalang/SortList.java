package javalang;


// inspired by jayadev's answer on http://stackoverflow.com/questions/7685/merge-sort-a-linked-list
// however, I improved it by checking for more null pointers in the findMid method to avoid null pointer exception

import javalang.commons.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null) // only one element
            return head;
        ListNode mid = findMid(head);
        ListNode nextToMid = mid.next;
        mid.next = null; //break list here
        
        return merge(sortList(head), sortList(nextToMid));
    }
    
    //@return: head of the merged list
    public static ListNode merge(ListNode a, ListNode b){
        if(a==null || b==null)
            return a==null? b : a;
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        while(a!=null && b!=null){
            if(a.val<=b.val){
                temp.next = a; 
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp=temp.next;
        }
        temp.next = a==null? b: a;
        return dummyHead.next;
    }
    
    
    public static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(slow.next!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}