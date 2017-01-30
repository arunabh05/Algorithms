package practice;

public class LinkedList {
	static Node head;
	 class Node {
		int data;
		Node next;

		public Node(int value) {
			data = value;
			next = null;
		}
	}

	public Node insertFirst(int data) {

		Node node = new Node(data);
		node.next = head;
		head = node;
		return head;
	}

	public Node insertLast(int data) {

		Node node = new Node(data);

		if (head == null) {
			head = node;
			return head;
		}

		Node current = head;
		while (current.next != null) {
			current = current.next;
		}

		current.next = node;

		return head;
	}

	public Node insert( int pos, int data) {

		Node node = new Node(data);
		int count = 1;

		Node previous = null;
		Node current = head;
		while (current != null) {
			if (pos == count) {
				previous.next = node;
				node.next = current;
				return head;
			}
			count++;
			previous = current;
			current = current.next;
		}
		return head;
	}


	public void printList(){
		
		Node current = head;
		while(current != null){
			System.out.print(current.data+"->");
			current = current.next;
		}
		System.out.println();
		
	}
	
	
	
	public static void main(String args[]){
		
		LinkedList list = new LinkedList();
		list.insertFirst(3);
		list.printList();
		list.insertFirst(2);
		list.printList();
		list.insertFirst(7);
		list.printList();
		list.insertFirst(2);
		list.printList();
		list.insertFirst(5);
		list.printList();
		list.insertLast(0);
		list.printList();
		list.insert(3, 8);
		list.printList();
	}

}
