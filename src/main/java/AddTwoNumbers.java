//package main.java;
//
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) {
// *         val = x;
// *         next = null;
// *     }
// * }
// */
//// #2 https://leetcode.com/problems/add-two-numbers/submissions/
//public class AddTwoNumbers {
//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     *     int val;
//     *     ListNode next;
//     *     ListNode(int x) { val = x; }
//     * }
//     */
//    class Solution {
//
//        private ListNode<Integer> head = null;
//        private ListNode<Integer> curr = null;
//
//        public ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
//            if (l1 == null && l2 == null) {
//                return null;
//            }
//
//            if (l1 == null || l2 == null) {
//                return l1 == null? l2 : l1;
//            }
//
//            int carry = 0;
//
//            while(l1 != null && l2 != null) {
//                int mod = (l1.val + l2.val + carry) % 10;
//                carry = (l1.val + l2.val + carry) / 10;
//                addNode(mod);
//                l1 = l1.next;
//                l2 = l2.next;
//            }
//
//            while (l1 != null) {
//                int mod = (l1.val + carry) % 10;
//                carry = (l1.val + carry) / 10;
//                addNode(mod);
//                l1 = l1.next;
//            }
//
//            while (l2 != null) {
//                int mod = (l2.val + carry) % 10;
//                carry = (l2.val + carry) / 10;
//                addNode(mod);
//                l2 = l2.next;
//            }
//            if (carry != 0) {
//                addNode(carry);
//            }
//
//            return head;
//        }
//
//        // returns carry
//        private void addNode(int val) {
//            if (head == null) {
//                head = new ListNode(val);
//                curr = head;
//            } else {
//                ListNode newNode = new ListNode(val);
//                curr.next = newNode;
//                curr = curr.next;
//            }
//        }
//    }
//
//}