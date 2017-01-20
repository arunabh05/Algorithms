package com.StackAndQueue;

public class TwoStackQueue {

	Stack stack1;
	Stack stack2;

	class Stack {

		class Node {
			private int data;
			private Node next;

			public Node(int value) {
				data = value;
			}
		}

		Node top;

		public Stack(int data) {
			Node newNode = new Node(data);
			top = newNode;
		}

		public void push(int data) {
			Node newNode = new Node(data);
			newNode.next = top;
			top = newNode;
		}

		public int peek() {
			if (top == null) {
				return -1;
			}
			int data = top.data;
			return data;
		}

		public boolean isEmpty() {
			return top == null;
		}

		public int pop() {
			if (top == null) {
				return -1;
			}
			int data = top.data;
			top = top.next;

			return data;
		}

	}

	public TwoStackQueue(int data) {
		if (stack1 == null) {
			stack1 = new Stack(data);
		}
	}

	public void enQueue(int data) {

		if (stack2 != null) {
			if (!stack2.isEmpty()) {
				while (!stack2.isEmpty()) {
					stack1.push(stack2.pop());
				}
			}
		}
		stack1.push(data);
	}

	public int deQueue() {

		if (stack2 == null) {
			System.out.println("creating second stack");
			stack2 = new Stack(stack1.pop());
		}

		if (!stack1.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		int data = stack2.pop();

		return data;
	}

	public static void main(String args[]) {

		TwoStackQueue queue = new TwoStackQueue(3);

		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(7);
		queue.enQueue(9);

		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());

	}
}
