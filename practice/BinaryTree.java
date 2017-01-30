package practice;

public class BinaryTree {

	static Node root;
	class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int value){
			data = value;
		}
	}
	
	public void insert(Node node,int data){
		
		Node newNode = new Node(data);
		if(root == null){
			root = newNode;
			return;
		}
		
		if(data < node.data){
			insert(node.left,data);
		}else{
			insert(node.right,data);
		}
	}
	
	public void printTree(Node root){
		
		if(root == null){
			return;
		}

		System.out.println(root.data);
		if(root.left != null){
			printTree(root.left);
		}
		if(root.right != null){
			printTree(root.right);
		}
	}
	
	public static void main(String args[]){
		
		BinaryTree bt = new BinaryTree();
		bt.insert(root, 3);
		bt.printTree(root);
		bt.insert(root, 2);
		bt.printTree(root);
		bt.insert(root, 1);
		bt.printTree(root);
		
	}
}
