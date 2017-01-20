package com.StackAndQueue;

public class SortStack {

	Stack stack;
	Stack tempStack;

	class Stack {

		private Node top;

		class Node {
			private int data;
			private Node next;

			public Node(int value) {
				data = value;
			}
		}

		public Stack(int data) {
			Node newNode = new Node(data);
			top = newNode;
		}

		public void push(int data) {

			Node newNode = new Node(data);
			newNode.next = top;
			top = newNode;
		}

		public int pop() {
			if (top == null) {
				System.out.println("Empty Stack Exception");
				return -1;
			}
			int data = top.data;
			top = top.next;
			return data;
		}

		public int peek() {
			if (top == null) {
				System.out.println("Empty Stack Exception. Cant Peek");
				return -1;
			}
			int data = top.data;
			return data;
		}

		public boolean isEmpty() {
			return top == null;
		}
	}

	public static void main(String args[]) {

		SortStack sortedStack = new SortStack(10);

		sortedStack.sortedPush(18);
		sortedStack.sortedPush(14);
		sortedStack.sortedPush(16);
		sortedStack.sortedPush(12);

		System.out.println(sortedStack.pop());
		System.out.println(sortedStack.pop());
		System.out.println(sortedStack.pop());
		System.out.println(sortedStack.pop());
		System.out.println(sortedStack.pop());

	}

	public SortStack(int data) {
		if (stack == null) {
			stack = new Stack(data);
		}
	}

	public void sortedPush(int data) {
		if (!stack.isEmpty()) {
			while (!stack.isEmpty() && data > stack.peek()) {
				if (tempStack == null) {
					tempStack = new Stack(stack.pop());
				} else {
					tempStack.push(stack.pop());
				}
			}

		}
		stack.push(data);

		if (tempStack != null) {
			while (!tempStack.isEmpty()) {
				stack.push(tempStack.pop());
			}

		}
	}

	public int pop() {
		return stack.pop();
	}

}
