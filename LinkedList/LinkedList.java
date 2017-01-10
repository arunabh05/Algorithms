package com.LinkedList;

import java.util.HashSet;

public class RemoveDups {

	public static void main(String args[]) {

		RemoveDups main = new RemoveDups();
		Node head = main.new Node(1);

		head.addNode(head, 3);
		head.addNode(head, 5);
		head.addNode(head, 2);
		head.addNode(head, 3);

		head.printLinkedList(head);
		System.out.println("");
//		head.removeDuplicate(head);

		head.printLinkedList(head);

		System.out.println("");

	//	System.out.println("Kth element from Last is: " + head.findKth(2, head));
		
	//	head.deleteMiddleElement(head.next.next);

	//	head.printLinkedList(head);
		head.partitionK(5, head);
		
		head.printLinkedList(head);
		
	}

	public class Node {

		int data;
		Node next = null;

		public Node(int d) {
			data = d;
		}

		public void printLinkedList(Node head) {
			Node current = head;
			while (current != null) {
				System.out.print(current.data + " -> ");
				current = current.next;
			}
		}

		public Node addNode(Node head, int data) {

			Node current = head;
			Node newNode = new Node(data);
			newNode.data = data;

			while (current.next != null) {
				current = current.next;
			}

			current.next = newNode;
			return current;
		}

		// time complexity O(n^2)
		// space complexity O(1)
		public void deleteDuplicate(Node head) {

			Node current = head;

			while (current.next != null) {
				Node checker = current;
				while (checker.next != null) {
					if (checker.next.data == current.data) {
						checker.next = checker.next.next;
					} else {
						checker = checker.next;
					}
				}
				current = current.next;
			}
		}

		// time complexity O(n)
		public void removeDuplicate(Node head) {

			Node current = head;
			HashSet<Integer> set = new HashSet<Integer>();
			Node previous = null;
			while (current != null) {
				if (set.contains(current.data)) {
					previous.next = current.next;
				} else {
					set.add(current.data);
					previous = current;

				}
				current = current.next;
			}

		}

		//time complexity : O(n)
		public int findKth(int k, Node head) {

			Node current = head;

			if (current == null) {
				return -1;
			}

			int count = 0;

			while (current != null) {
				current = current.next;
				count++;
			}

			current = head;
			int index = count - k + 1;
			int finalCount = 1;
			while (current != null) {
				if (finalCount == index) {
					return current.data;
				}
				finalCount++;
				current = current.next;
			}

			return -1;
		}
		
		
		public void deleteMiddleElement(Node mid){
			
			if(mid != null && mid.next != null){
				mid.data = mid.next.data;
				mid.next= mid.next.next;
			}
			
		}
		
		
		public void partitionK(int k,Node head){
			
			Node current = head;
			Node previous = null;
			while(current != null){
				System.out.println(current.data);
				if(current.data <= k){
					Node newNode = new Node(current.data);
					newNode.next = head;
					head = newNode;
					previous.next = current.next;
					current = previous;
				}else{
					previous = current;
				}
				current = current.next;
			}
			
			
		}
		
		
	}
}
  