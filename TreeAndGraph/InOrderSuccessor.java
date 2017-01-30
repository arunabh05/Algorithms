package com.TreeAndGraph;

public class InOrderSuccessor {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		public TreeNode(int value) {
			data = value;
			parent = left = right = null;
		}
	}

	

	public TreeNode insert(TreeNode root, int data) {
		if (root == null) {
			TreeNode n = new TreeNode(data);
			root = n;
			return root;
		}
		if (data < root.data) {
			root.left = insert(root.left, data);
			root.left.parent = root;
		}
		if (data >= root.data) {
			root.right = insert(root.right, data);
			root.right.parent = root;
		}

		return root;
	}

	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		if (root.left != null) {
			inOrder(root.left);
		}

		System.out.print(root.data+" ");
		if (root.right != null) {
			inOrder(root.right);
		}
	}
	
	public TreeNode inOrderSuccessor(TreeNode root) {
		TreeNode current;
		if(root == null){
			return root;
		}

		System.out.println(root.left.data);
		
		if(root.right !=null){
			current = root.right;
			while (current.left != null) {
				current = current.left;
			}
			return current;
		}
		
		TreeNode p = root.parent;
		while(p != null && root == p.right ){
			root = p;
			p = p.parent;
		}
		return p;
	}

	public static void main(String args[]) {

		TreeNode t1 = new TreeNode(5);

		InOrderSuccessor bst = new InOrderSuccessor();
		bst.insert(t1, 3);
		bst.insert(t1, 7);
		bst.insert(t1, 1);
		bst.insert(t1, 4);
		bst.insert(t1, 6);
		bst.insert(t1, 8);
		bst.insert(t1, 2);
		bst.insert(t1, 9);
		bst.inOrder(t1);
		System.out.println("");
		System.out.println(bst.inOrderSuccessor(t1).data);
	}
}