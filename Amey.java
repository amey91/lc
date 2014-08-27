package leetcode;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class Amey {
	public static void printList(ListNode head){
		ListNode temp = head;
		StringBuilder sb = new StringBuilder();
		while(temp!=null){
			sb.append(temp.val+" ");
			temp=temp.next;
//			log(sb.toString());
		}
		log("List :: " + sb.toString());
	}

	public static ListNode convertStringToList(String s, char startBracket, char endBracket,
			String delimiter) {

		s=s.replace(startBracket+"","");
		s=s.replace(endBracket+"","");
		String[] nodes = s.split(delimiter);
		if(nodes.length==0)
			return null;
		ListNode head = new ListNode(Integer.parseInt(nodes[0]));
		ListNode curr= head;
		for(int i=1; i<nodes.length;i++){
			ListNode temp = new ListNode(Integer.parseInt(nodes[i]));
			curr.next = temp;
			curr=curr.next;
		}
		return head;
	}

	public static void log(Object s){
		System.out.println(s);
/*
		PriorityQueue pq = new PriorityQueue(9);
		LinkedHashMap lhmap = new LinkedHashMap();
		lhmap.remove(lhmap.entrySet().iterator().next());
*/
	}
}

class Amey2 extends Amey{
	
	public static void printList(ListNode head){
		log("Called from child class");
		printList(head);
	}
}
