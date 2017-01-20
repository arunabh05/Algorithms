package com.StackAndQueue;

import java.util.ArrayList;

public class StackOfPlates {

	ArrayList<Stack> stacks = new ArrayList<Stack>();
	Stack newStack = new Stack(-101);

	public StackOfPlates(int data) {
		Stack first = new Stack(data);
		first.capacity++;
		stacks.add(first);
	}

	public void push(int data) {
		newStack.push(data);
	}

	public int pop() {
		return newStack.pop();
	}

	public static void main(String args[]) {

		StackOfPlates sop = new StackOfPlates(5);
		sop.push(4);
		sop.push(6);
		sop.push(4);
		sop.push(2);
		sop.push(9);
		sop.push(0);

		sop.push(44);
		sop.push(66);
		sop.push(3);
		sop.push(76);
		sop.push(23);
		System.out.println("popped:" + sop.pop());
		System.out.println("popped:" + sop.pop());
		System.out.println("popped:" + sop.pop());
		System.out.println("popped:" + sop.pop());
		System.out.println("popped:" + sop.pop());
		System.out.println("popped:" + sop.pop());

	}

	public class Stack {
		int data;
		Stack next;
		int capacity = 0;

		public Stack(int value) {
			data = value;
			top = this;
		}

		Stack top;

		public void push(int data) {
			Stack newItem = new Stack(data);
			System.out.println(stacks.size());
			Stack last = stacks.get(stacks.size() - 1);
			if (last.capacity < 3) {
				newItem.next = last.top;
				last.top = newItem;
				last.capacity++;
			} else {
				Stack st = new Stack(data);
				st.capacity++;
				stacks.add(st);
			}

			if (top == null) {
				top = newItem;
			}

		}

		public int pop() {
			Stack last = stacks.get(stacks.size() - 1);
			if (last == null) {
				System.out.println("Error");
				return -1;
			}

			int data = last.top.data;

			last.capacity--;
			if (last.capacity == 0) {
				stacks.remove(stacks.size() - 1);
			} else {
				last.top = last.top.next;
			}

			System.out.println(stacks.size());
			return data;
		}

		public int popAt() {
			return -1;
		}
	}
}
