package leetcode.commons;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListNode<E> extends ArrayList<E> {
	private static final long serialVersionUID = -9216634136972409241L;
	
	public E val;
      public ListNode<E> next;
      public ListNode(E x) {
          val = x;
          next = null;
     }
      
      @Override
      public String toString(){
    	  return val+"";
      }
 }