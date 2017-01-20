package com.StackAndQueue;

public class Stack {

	Node top;

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
			return -1;
		}
		int data = top.data;
		top = top.next;

		return data;
	}

	
	
	public static void main(String args[]){
		
		Stack st1 = new Stack(3);
		st1.push(4);
		st1.push(5);
		st1.push(7);
		st1.push(2);
		st1.push(6);
		
		System.out.println(st1.pop());
		System.out.println(st1.pop());
		System.out.println(st1.pop());
		System.out.println(st1.pop());
		System.out.println(st1.pop());
		System.out.println(st1.pop());

	}

}
