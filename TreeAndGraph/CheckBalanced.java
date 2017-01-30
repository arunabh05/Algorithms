package com.TreeAndGraph;

public class CheckBalanced {

	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int value) {
			data = value;
		}

	}

	public static int checkBalanced(TreeNode root) {

		if (root == null) {
			return -1;
		} 
		
		int lh = checkBalanced(root.left);
		if(lh == Integer.MIN_VALUE){
			System.out.println("here");
			return Integer.MIN_VALUE;
		}

		int rh = checkBalanced(root.right);
		if(rh == Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}

		int hd = lh - rh;
		if(Math.abs(hd) > 1){
			return Integer.MIN_VALUE;
		}
		
		return Math.max(lh, rh) + 1;
	}

	static boolean isBalance(TreeNode root){
		return checkBalanced(root) != Integer.MIN_VALUE;
	}
	
	public static void main(String args[]) {

		CheckBalanced cb = new CheckBalanced();

		TreeNode n1 = cb.new TreeNode(1);
		TreeNode n2 = cb.new TreeNode(2);
		TreeNode n3 = cb.new TreeNode(3);
		TreeNode n4 = cb.new TreeNode(4);
		TreeNode n5 = cb.new TreeNode(5);
		TreeNode n6 = cb.new TreeNode(6);
		TreeNode n7 = cb.new TreeNode(7);

		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n2.right = n5;

		n3.left = n6;
		n3.right = n7;

		System.out.println(isBalance(n1));
	}

}
