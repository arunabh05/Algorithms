package com.LinkedList;

import java.util.HashSet;

public class RemoveDups {

	public static void main(String args[]) {

		RemoveDups main = new RemoveDups();
		Node head = main.new Node(1);

		head.addNode(head, 11);
		head.addNode(head, 5);
		head.addNode(head, 2);
		head.addNode(head, 3);

		Node head2 = main.new Node(1);

		head2.addNode(head2, 5);
		head2.addNode(head2, 3);
		head2.addNode(head2, 6);
		head2.addNode(head2, 2);

		head.printLinkedList(head);
		System.out.println("");
		head2.printLinkedList(head2);
		System.out.println("");

		// head.removeDuplicate(head);

		// head.printLinkedList(head);

		System.out.println("");

		// System.out.println("Kth element from Last is: " + head.findKth(2,
		// head));

		// head.deleteMiddleElement(head.next.next);

		// head.printLinkedList(head);

		// Node h = head.partitionK(5, head);

		// h.printLinkedList(h);

		Node sumList = head.sumList(head, head2);
		sumList.printLinkedList(sumList);

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

		// time complexity : O(n)
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

		public void deleteMiddleElement(Node mid) {

			if (mid != null && mid.next != null) {
				mid.data = mid.next.data;
				mid.next = mid.next.next;
			}

		}

		// time complexity - O(n)
		public Node partitionK(int k, Node head) {

			Node current = head;
			Node previous = null;
			while (current != null) {
				if (current.data < k) {
					if (previous != null) {
						previous.next = current.next;
						current.next = head;
						head = current;
						current = previous;
					}
				} else {
					previous = current;
				}
				current = current.next;
			}

			return head;
		}

		// time complexity - O(n)
		public Node partitionN(int k, Node node) {

			Node head = node;
			Node tail = node;
			while (node != null) {
				Node next = node.next;
				// System.out.println(node.data);
				if (node.data < k) {
					node.next = head;
					head = node;
				} else {
					tail.next = node;
					tail = node;
				}
				node = next;
			}
			tail.next = null;

			return head;
		}

		public Node sumList(Node node, Node node2) {

			Node head = node;
			Node head1 = node2;
			Node head2 = null;
			int rem = 0;
			while (head1 != null || head != null) {

				int fulldata = head1.data + head.data + rem;
				rem = 0;
				int data = fulldata;

				if (fulldata >= 10) {
					data = data % 10;
					rem = 1;
				}

				Node newNode = new Node(data);
				newNode.next = head2;
				head2 = newNode;
				head1 = head1.next;
				head = head.next;
			}
			return head2;
		}

	}

}
