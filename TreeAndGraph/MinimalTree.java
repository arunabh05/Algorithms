package com.TreeAndGraph;

import java.util.LinkedList;
import java.util.Queue;

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

	

    public int maxDepth(TreeNode root,int data){

      if(root == null){
          return -1;
      }
      
      int depth = 0;
      int dep = 0;       
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      q.add(root);
      
      while(!q.isEmpty()){
          TreeNode n = q.remove();

           if(data == n.data){
               if(dep >= depth){
                  depth =  dep;
               }
           }
          
          System.out.println(n.data);
          if(n.leftChild != null){
              q.add(n.leftChild);
          }
          if(n.rightChild!= null){
              q.add(n.rightChild);
          }
          
          if(n.leftChild !=null && n.rightChild != null){
              dep++;
          }

     }
  return depth;
  }
}
