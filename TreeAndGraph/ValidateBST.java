package com.TreeAndGraph;

public class ValidateBST {
	TreeNode root;

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int value) {
			data = value;
			left = right = null;
		}

		public TreeNode insertNode(TreeNode root, int data) {
			if (root == null) {
				TreeNode newNode = new TreeNode(data);
				root = newNode;
				return root;
			}
			if (root.data > data) {
				root.left = insertNode(root.left, data);
			} else {
				root.right = insertNode(root.right, data);
			}

			return root;
		}

		public void preOrder(TreeNode n) {
			if (n == null) {
				return;
			}

			if (n.left != null || n.right != null) {
				System.out.println("Parent ---->" + n.data);
			}

			if (n.left != null) {
				System.out.println("Left Child-->" + n.left.data);

			}
			if (n.right != null) {
				System.out.println("Right Child-->" + n.right.data);

			}

			preOrder(n.left);
			preOrder(n.right);
		}

		public boolean validateBST(TreeNode root) {
			if (root == null) {
				return true;
			}

			if (root.left != null && root.data < root.left.data) {
				return false;
			}

			if (root.right != null && root.data >= root.right.data) {
				return false;
			}

			if (!validateBST(root.left) || !validateBST(root.right)) {
				return false;
			}
			return true;
		}
	}

	public static void main(String args[]) {
		TreeNode t1 = new TreeNode(5);
		t1.preOrder(t1);
		System.out.println();
		t1.insertNode(t1, 3);
		t1.preOrder(t1);
		System.out.println();
		t1.insertNode(t1, 7);
		t1.preOrder(t1);
		System.out.println();
		t1.insertNode(t1, 1);
		t1.preOrder(t1);
		System.out.println();
		t1.insertNode(t1, 4);
		t1.preOrder(t1);
		System.out.println();
		t1.insertNode(t1, 6);
		t1.preOrder(t1);
		System.out.println();
		t1.insertNode(t1, 8);
		t1.preOrder(t1);
		System.out.println();
		t1.insertNode(t1, 2);
		t1.preOrder(t1);
		System.out.println();
		t1.insertNode(t1, 0);
		t1.preOrder(t1);
		System.out.println();
		System.out.println(t1.validateBST(t1));
	}
}
