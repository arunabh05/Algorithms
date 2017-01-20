package com.StackAndQueue;

public class StackMin {

	public static void main(String args[]) {
		StackMin main = new StackMin();
		Stack st = main.new Stack(1);

		st.push(3);
		System.out.println("min:" + st.min());
		st.push(4);
		System.out.println("min:" + st.min());
		st.push(7);
		System.out.println("min:" + st.min());
		st.push(2);
		System.out.println("min:" + st.min());
		System.out.println("peek" + st.peek());
		System.out.println("remove:" + st.pop());
		System.out.println("min:" + st.min());
		System.out.println("remove:" + st.pop());
		System.out.println("min:" + st.min());
		System.out.println("peek" + st.peek());
		st.push(1);
		System.out.println(st.min());
	}

	public class Stack {
		private int data;
		private Stack next;
		private int min = 100000;

		public Stack(int value) {
			data = value;
		}

		private Stack top;

		public int min() {
			if (top == null) {
				return 1000000;
			}
			return top.min;
		}

		public void push(int value) {
			int min = min();
			if (min > value) {
				min = value;
			}
			Stack newItem = new Stack(value);
			newItem.next = top;
			newItem.min = min;
			top = newItem;
		}

		public int pop() {
			if (top == null) {
				return -1;
			}
			int item = top.data;
			top = top.next;
			return item;
		}

		public int peek() {
			if (top == null) {
				return -1;
			}
			return top.data;
		}

	}
}
