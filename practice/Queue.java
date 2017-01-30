package practice;

public class Queue {

	Node head;
	Node rear;
	
	class Node{
		int data;
		Node next;
	
		public Node(int value){
			data = value;
		}
	}
	
	
	public void enQueue(int data){
		Node newNode = new Node(data);
		if(rear != null){
			rear.next = newNode;
		}
		
		rear = newNode;

		if(head == null){
			head = rear;
		}
	}
	
	public int deQueue(){
		
		
		if(head== null){
			System.out.println("underflow");
			return -1;
		}
		
		int value = head.data;
		head = head.next;
		
		return value;
	}

	public void printAll(){
		Node current = head;
		while(current != null){
			System.out.println(current.data+"->");
			current = current.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		
		Queue q = new Queue();
		q.enQueue(1);
		q.printAll();
		q.enQueue(2);
		q.printAll();
		q.enQueue(3);
		q.printAll();
		q.enQueue(4);
		q.printAll();
		q.deQueue();
		q.printAll();
	}
}
