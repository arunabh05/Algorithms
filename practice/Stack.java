package practice;

public class Stack {

	static Node top;

	class Node {
		int data;
		Node next;

		public Node(int value) {
			data = value;
		}
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}

	public int pop() {
		if (top == null) {
			System.out.println("Stack underflow");
			return -1;
		}

		int value = top.data;
		top = top.next;

		return value;
	}

	public int peek() {
		if (top == null) {
			System.out.println("Stack underflow");
			return -1;
		}
		return top.data;
	}

	public void printAll(){
		
		Node current = top;
		while(current != null){
			System.out.print(current.data+"->");
			current = current.next;
		}
		System.out.println();
	}
	
	
	public static void main(String args[]){
		
		Stack st = new Stack();
		st.push(3);
		st.printAll();
		st.push(4);
		st.printAll();
		st.push(1);
		st.printAll();
		st.push(8);
		st.printAll();
		st.push(7);
		st.printAll();
		System.out.println("peek:"+st.peek());
		st.pop();
		st.printAll();
		st.pop();
		st.printAll();
		st.pop();
		st.printAll();
		st.pop();
		st.printAll();
		
	}
}
