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
		head.removeDuplicate(head);

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

		//time complexity O(n^2)
		//space complexity O(1)
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
			System.out.println("here");
		}


		
		//time complexity O(n)
		public void removeDuplicate(Node head) {

			Node current = head;
			HashSet<Integer> set = new HashSet<Integer>();

			while (current.next != null) {
				if (set.contains(current.next.data)) {
					current.next = current.next.next;
				} else {
					set.add(current.data);
					current = current.next;

				}

			}

		}
	}
}
