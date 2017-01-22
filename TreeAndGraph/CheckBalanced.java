package com.TreeAndGraph;

public class CheckBalanced {

	class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		
		public TreeNode(int value){
			data = value;
		}
		
	}
	
	public static int checkBalanced(TreeNode root){
		
		int lh,rh;
		
		if(root == null){
			return 0;
		} else{
			lh = checkBalanced(root.left);
			rh = checkBalanced(root.right);
			
			if(lh  > rh){
				return lh + 1;
			}else{
				return rh + 1;
			}

		}
	}
	
	public static void main(String args[]){
		
		CheckBalanced cb =new CheckBalanced();
	
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
		
		n4.left = n6;
		n4.right = n7;
	
		System.out.println(checkBalanced(n1));
	}
	
}
