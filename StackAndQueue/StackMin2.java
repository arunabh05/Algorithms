package com.StackAndQueue;

public class StackMin2 {

	static java.util.Stack<Integer> minStack = new java.util.Stack<Integer>();
	public static void main(String args[]) {
		StackMin2 sm = new StackMin2();
		Stack st = sm.new Stack(1);
		minStack.push(5);
		
		System.out.println("min:"+st.min());
		st.push(2);
		System.out.println("min:"+st.min());
		st.push(1);
		System.out.println(st.peek());
		System.out.println("min:"+st.min());
		System.out.println(st.pop());
		
		System.out.println(st.pop());
		System.out.println(st.min());
		
	}

	public class Stack {
		private int data;
		private Stack next;

		public Stack(int value) {
			data = value;
		}

		Stack top;

		public void push(int data) {
			if (min() >= data) {
				minStack.push(data);
			}

			Stack newItem = new Stack(data);
			newItem.next = top;
			top = newItem;
		}

		
		public int pop() {
			if (top == null) {
				return -1;
			}
			int data = top.data;

			if (data == min()) {
				minStack.pop();
			}

			top = top.next;
			return data;
		}

		public int peek() {
			if (top == null) {
				return -1;
			}
			System.out.println();
			return top.data;
		}

		public int min() {
			return minStack.peek();
		}
	}
}
