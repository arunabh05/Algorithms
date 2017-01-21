package com.TreeAndGraph;

public class MinimalTree {

	class TreeNode {
		int data;
		TreeNode leftChild;
		TreeNode rightChild;

		public TreeNode(int value) {
			data = value;
		}
	}
	
	public static void main(String args[]){
		MinimalTree mt = new MinimalTree();
		
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		mt.createMinimalBST(arr);
	}

	public TreeNode createMinimalBST(int arr[]) {
		return createMinimalBST(arr, 0, arr.length - 1);
	}

	public TreeNode createMinimalBST(int arr[], int start, int end) {

		if (start > end) {
				return null;
		}
		
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		
		
		n.leftChild = createMinimalBST(arr ,start,mid - 1);
		n.rightChild = createMinimalBST(arr ,mid + 1,end);

		if(n.leftChild !=null || n.rightChild != null){
			System.out.println("Parent ---->"+n.data);
		}
		
		if(n.leftChild != null){
			System.out.println("Left Child-->"+n.leftChild.data);
			
		}
		if(n.rightChild != null){
			System.out.println("Right Child-->"+n.rightChild.data);
			
		}

		return n;
	}

}
