package javasolutions.commons;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public int val;
	
	public TreeNode(int val){
		left = null;
		right = null;
		this.val = val;
	}
	
	public TreeNode(int val, TreeNode left, TreeNode right){
		this.val = val;
		this.right = right;
		this.left = left;
	}
}
