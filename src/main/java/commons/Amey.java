package commons;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Amey {

	public static void main(String args[]){
		//		String input = "[2,1,3,4,5,6,7]";
		//		ListNode head = convertStringToList(input, '[', ']', ",");
		//		displayList(head);
		//		System.out.println("abcd is palindrome is : "+ checkPalindrome("abcd"));
		//		System.out.println("aaa is palindrome is : "+ checkPalindrome("aaa"));
		//		System.out.println("abccba is palindrome is : "+ checkPalindrome("abccba"));
		//		System.out.println("\"\" is palindrome is : "+ checkPalindrome(""));
		//		System.out.println("abcdcba is palindrome is : "+ checkPalindrome("abcdcba"));
		String s1 = "321zyxabcdefg321zyxabcdefg321zyxabcdefghgfedcbaxyz123gfedcbaxyz123gfedcbaxyz123";
		Amey amey =  new Amey();
		try{
			Method m1 = amey.getClass().getDeclaredMethod("checkPalindromeUsingCharArray", s1.getClass());
			Method m2 = amey.getClass().getDeclaredMethod("checkPalindromeUsingReverse", s1.getClass());
			Method m3 = amey.getClass().getDeclaredMethod("checkPalindromeUsingCharAt", s1.getClass());
			System.out.println("Palindrome using reverse takes "+ methodPerformance(amey, m2 , s1)+" mS");
			System.out.println("Palindrome using tochararray takes "+ methodPerformance(amey, m1 , s1)+" mS");
			System.out.println("Palindrome using charat takes "+ methodPerformance(amey, m3 , s1)+" mS");
		} catch(Exception e){
			e.printStackTrace();
		}
	}

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

	@SuppressWarnings("unchecked")
	public static <E> ListNode<E> convertStringToList(String s, char startBracket, char endBracket,
			String delimiter, Class<E> clas) {

		s=s.replace(startBracket+"","");
		s=s.replace(endBracket+"","");
		String[] nodes = s.split(delimiter);
		if(nodes.length==0)
			return null;
		if(clas.getClass().equals(Integer.class)){
			ListNode<Integer> head = new ListNode<>(Integer.parseInt(nodes[0]));
			ListNode<Integer> curr= head;
			for(int i=1; i<nodes.length;i++){
				ListNode<Integer> temp = new ListNode<>(Integer.parseInt(nodes[i]));
				curr.next = temp;
				curr=curr.next;
			}
			return (ListNode<E>) head;
		}
		
		if(clas.getClass().equals(String.class)){
			ListNode<String> head = new ListNode<>(nodes[0]);
			ListNode<String> curr= head;
			for(int i=1; i<nodes.length;i++){
				ListNode<String> temp = new ListNode<>(nodes[i]);
				curr.next = temp;
				curr=curr.next;
			}
			System.out.println("HOLA");
			return (ListNode<E>) head;
		}
		
		System.out.println(clas.getClass().getName());
		return null;
	}

	public static <E> void displayList(ListNode<E> head){
		StringBuilder sb = new StringBuilder();
		while(head!=null){
			sb.append(" " + head.val.toString());
			head = head.next;
		}
		System.out.println("The list = "+ sb.toString());
	}

	public static void log(Object s){
		System.out.println(s);
		/*
		PriorityQueue pq = new PriorityQueue(9);
		LinkedHashMap lhmap = new LinkedHashMap();
		lhmap.remove(lhmap.entrySet().iterator().next());
		 */
	}

	public static TreeNode makeTree(String nodeList, char delimiter){
		String[] nodes = nodeList.split(String.valueOf(delimiter));
		TreeNode head = new TreeNode(Integer.parseInt(nodes[0]));
		for(int i=1; i< nodes.length; i++){
			head = insertIntoTree(head, Integer.parseInt(nodes[i]));
		}
		return head;
	}

	public static TreeNode insertIntoTree(TreeNode head, int val){
		TreeNode temp = head;
		while(temp!=null){
			if(temp.val<val){
				//traverse right tree
				if(temp.right==null){
					temp.right = new TreeNode(val);
					return head;
				} 
				temp=temp.right;
			} else {
				//traverse left tree
				if(temp.left==null){
					temp.left = new TreeNode(val);
					return head;
				}
				temp = temp.left;
			}
		}
		return head;
	}

	public static void displayTreeInorder(TreeNode head) {
		StringBuilder s = inorderTraversal(head, new StringBuilder());
		log("InorderTraversal: "+ s.toString());
	}

	private static StringBuilder inorderTraversal(TreeNode node, StringBuilder s) {
		if(node == null)
			return s;
		inorderTraversal(node.left, s);
		s.append(node.val);
		inorderTraversal(node.right, s);
		return s;

	}

	public static boolean checkPalindromeUsingCharArray(String s){
		if(s==null || s.equals(""))
			return false;
		char[] c = s.toCharArray();
		int left = 0;
		int right = c.length-1;
		while(left<right){
			if(c[left++]!=c[right--])
				return false;
		}
		return true;
	}

	public static boolean checkPalindromeUsingReverse(String s){
		if(s==null || s.equals(""))
			return false;
		return s.equals(new StringBuilder(s).reverse().toString());
	}

	public static boolean checkPalindromeUsingCharAt(String s){
		if(s==null || s.equals(""))
			return false;
		int left = 0;
		int right = s.length()-1;
		while(left<right){
			if(s.charAt(left++)!=s.charAt(right--))
				return false;
		}
		return true;
	}

	public static long methodPerformance(Object object, Method method, String a){
		long initial = System.nanoTime();
		try {
			int i = 0;
			for(; i<1000000; i++)
				method.invoke(object, a);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return (System.nanoTime()-initial)/1000000;
	}
}

class Amey2 extends Amey{

	public static void printList(ListNode head){
		log("Called from child class");
		printList(head);
	}
}


