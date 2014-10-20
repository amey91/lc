package leetcode;

import leetcode.commons.ListNode;

 
// inspired by jayadev's answer on http://stackoverflow.com/questions/7685/merge-sort-a-linked-list
// however, I improved it by checking for more null pointers in the findMid method to avoid null pointer exception

public class SortList {
    public ListNode<Integer> sortList(ListNode<Integer> head) {
        if(head == null || head.next==null) // only one element
            return head;
        ListNode<Integer> mid = findMid(head);
        ListNode<Integer> nextToMid = mid.next;
        mid.next = null; //break list here
        
        return merge(sortList(head), sortList(nextToMid));
    }
    
    //@return: head of the merged list
    public static ListNode<Integer> merge(ListNode<Integer> a, ListNode<Integer> b){
        if(a==null || b==null)
            return a==null? b : a;
        ListNode<Integer> dummyHead = new ListNode<Integer>(-1);
        ListNode<Integer> temp = dummyHead;
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
    
    
    public static ListNode<Integer> findMid(ListNode<Integer> head){
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
        while(slow.next!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}