package main.java;

import main.java.commons.RandomListNode;

import java.util.HashMap;



/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return head;
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = head;
        RandomListNode head_ = new RandomListNode(head.label);
        RandomListNode curr_ = head_;
        map.put(head, head_);
        
        curr=curr.next;
        while(curr!=null){
            curr_.next = new RandomListNode(curr.label);
            curr_=curr_.next;
            map.put(curr, curr_);
            curr=curr.next;
        }
        
        curr = head;
        curr_ = head_;
        while(curr!=null){
            if(curr.random!=null){
                curr_.random = map.get(curr.random);
            } else {
                curr_.random = null;
            }
            curr=curr.next;
            curr_=curr_.next;
        }
        return head_;
    }
}