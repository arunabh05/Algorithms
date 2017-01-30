package com.TreeAndGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ListOfDepths {

	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int value) {
			data = value;
		}
	}

    int depth = 0;
	int preOrder(TreeNode root,int data,int level){
	       if(root == null){
	           return -1;
	       }
	       
	       Queue<TreeNode> q = new LinkedList<TreeNode>();
	       q.add(root);
	       
	       while(!q.isEmpty()){
	    	   TreeNode n = q.remove();
	    	   
	            if(3 == n.data){
	                if(depth <= level){
	                   depth =  level;
	                }
	            }
	           
	         System.out.println(n.data);

	           if(n.left!=null){
	               q.add(n.left);
	               
	           }
	           if(n.right!= null){
	               q.add(n.right);
	           }
	       }
	   return depth;
	   }

	
	public void levelOrderSearch(TreeNode root) {

		if (root == null) {
			return;
		}

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		queue.addFirst(root);
		q.add(0);
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.removeLast();
			System.out.println(node.data);

			if (node.left != null) {
				System.out.println("");
				queue.addFirst(node.left);
				
			}
			if (node.right != null) {
				System.out.println("");
				queue.addFirst(node.right);
			}

		}
	}

	public ArrayList<LinkedList<TreeNode>> ListOfDepth(TreeNode root) {

		if (root == null) {
			return null;
		}

		ArrayList<LinkedList<TreeNode>> listOfDepths = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> newLevel = new LinkedList<TreeNode>();
		newLevel.add(root);
		
		while (newLevel.size() > 0) {
			listOfDepths.add(newLevel);
			
			LinkedList<TreeNode> previousLevel = newLevel;

			newLevel = new LinkedList<TreeNode>();

			for (TreeNode previous : previousLevel) {
				if (previous.left != null) {
					newLevel.addFirst(previous.left);
				}
				if (previous.right != null) {
					newLevel.addFirst(previous.right);
				}
			}

		}
		return listOfDepths;
	}

	public static void main(String args[]) {

		ListOfDepths Ldepths = new ListOfDepths();
		TreeNode n1 = Ldepths.new TreeNode(1);
		TreeNode n2 = Ldepths.new TreeNode(2);
		TreeNode n3 = Ldepths.new TreeNode(3);
		TreeNode n4 = Ldepths.new TreeNode(4);
		TreeNode n5 = Ldepths.new TreeNode(5);
		TreeNode n6 = Ldepths.new TreeNode(6);
		TreeNode n7 = Ldepths.new TreeNode(7);
		TreeNode n8 = Ldepths.new TreeNode(8);
		TreeNode n9 = Ldepths.new TreeNode(9);
		TreeNode n10 = Ldepths.new TreeNode(3);

		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n2.right = n5;

		n3.left = n6;
		n3.right = n7;

		n4.left = n8;
		n4.right = n9;

		n5.left = n10;

/*		ArrayList<LinkedList<TreeNode>> lists = Ldepths.ListOfDepth(n1);

		for (LinkedList<TreeNode> l : lists) {
			while (!l.isEmpty()) {
				System.out.print(l.removeFirst().data + "-->");
			}
			System.out.println("");
		}
		*/
		System.out.println("depth:"+Ldepths.preOrder(n1, 3,0));
	}
}
