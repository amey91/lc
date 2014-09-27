package leetcode.commons;

import java.util.LinkedList;

public class ListNode extends LinkedList<Integer> {
	private static final long serialVersionUID = -9216634136972409241L;
	
	public int val;
      public ListNode next;
      public ListNode(int x) {
          val = x;
          next = null;
     }
      
      @Override
      public String toString(){
    	  return val+"";
      }
 }