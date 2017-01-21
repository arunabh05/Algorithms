package com.TreeAndGraph;

import java.util.LinkedList;

public class AdjacencyListGraph {

	class Node {
		boolean visited;
		int data;
		Node[] children;

		public Node(int value, Node[] child) {
			visited = false;
			data = value;
			children = child;
		}
	}

	public void DFS(Node current) {

		if (current != null) {
			current.visited = true;
			System.out.println(current.data + "- >");

			if (current.children != null) {
				for (Node n : current.children) {

					if (n != null) {
						if (n.visited == false) {
							DFS(n);
						}
					}
				}
				System.out.println("backtracking ->" + current.data);
			}

		}
	}

	public void BFS(Node current) {
		current.visited = true;
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addFirst(current);
		while (!queue.isEmpty()) {
			Node n = queue.removeLast();
			System.out.println(n.data);
			if (n.children != null) {
				for (Node child : n.children) {
					if (child != null) {
						if (child.visited == false) {
							child.visited = true;
							queue.addFirst(child);
						}
					}
				}
			}

		}
	}

	public static void main(String args[]) {

		AdjacencyListGraph graph = new AdjacencyListGraph();

		Node child0[] = new Node[3];
		Node child1[] = new Node[2];
		Node child2[] = new Node[2];
		Node child3[] = new Node[2];
		Node child5[] = new Node[2];

		Node node0 = graph.new Node(0, child0);
		Node node1 = graph.new Node(1, child1);
		Node node2 = graph.new Node(2, child2);
		Node node3 = graph.new Node(3, child3);
		Node node4 = graph.new Node(4, null);
		Node node5 = graph.new Node(5, child5);

		child0[0] = node1;
		child0[1] = node4;
		child0[2] = node5;

		child1[0] = node2;
		child1[1] = node3;

		child2[1] = node5;

		child3[0] = node4;
		child3[1] = node5;

		child5[1] = node4;

		System.out.println("BFS ");
		graph.BFS(node0);

		System.out.println("DFS ");
		node0.visited = false;
		node1.visited = false;
		node2.visited = false;
		node3.visited = false;
		node4.visited = false;
		node5.visited = false;

		graph.DFS(node0);

	}
}
