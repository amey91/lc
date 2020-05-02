//package main.java;
//
//import java.util.List;
//
//import main.java.commons.ListNode;
//
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }
// */
//public class MergeKLists {
//    public ListNode mergeKLists(List<Integer>[] lists) {
//
//        if(null==lists) {
//            return null;
//        }
//        if(lists.length==1) {
//            return lists[0];
//        }
//
//        ListNode head = null;
//        ListNode currNode = null;
//        int emptyLists = 0;
//
//        while(emptyLists!=lists.length) {
//            int minIndex = getMinIndex(lists);
//            if(minIndex<0) {
//                return head;
//            }
//            if(head==null) {
//                head = lists[minIndex];
//                currNode=head;
//            } else {
//                currNode.next=lists[minIndex];
//                currNode=currNode.next;
//            }
//            lists[minIndex]=lists[minIndex].next;
//            if(lists[minIndex]==null) {
//                emptyLists++;
//            }
//        }
//
//        return head;
//
//    }
//
//    private int getMinIndex(ListNode<Integer>[] lists) {
//        int minIndex=-1;
//        int minValue=Integer.MAX_VALUE;
//        for(int i=0; i<lists.length; i++) {
//            if(null!=lists[i] && lists[i].val<minValue) {
//                minIndex=i;
//                minValue=lists[i].val;
//            }
//        }
//        return minIndex;
//
//    }
//}