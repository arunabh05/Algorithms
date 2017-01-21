package com.TreeAndGraph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class RouteBetweenNodes {

	public static void main(String args[]) {

		int[][] graph = new int[4][4];
		graph[0][0] = 0;
		graph[0][1] = 1;
		graph[0][2] = 0;
		graph[0][3] = 0;

		graph[1][0] = 0;
		graph[1][1] = 0;
		graph[1][2] = 1;
		graph[1][3] = 0;

		graph[2][0] = 1;
		graph[2][1] = 1;
		graph[2][2] = 1;
		graph[2][3] = 0;

		graph[3][0] = 0;
		graph[3][1] = 0;
		graph[3][2] = 0;
		graph[3][3] = 0;


		System.out.println(findRoute(graph, 0, 3));
	}
	// DFS
	public static boolean findRouteBetween(int[][] graph, int source, int destination) {
		
		for (int i = 0; i < graph.length; i++) {
			if (graph[source][i] == 1) {
				System.out.println(source+">>"+i);
					graph[source][i] = 2;
					if(i == destination){
						System.out.println("Path Found");
						return true;
					}
					if(findRouteBetween(graph, i, destination)){
						 return true;
					 }
				}
			}
		return false;
	}
	
	public static boolean findRoute(int[][] graph, int source, int destination){
		
		if(source == destination){
			return true;
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		graph[source][source] = 2;
		queue.addFirst(source);
		int next;
		while(!queue.isEmpty()){
			next = queue.removeLast();
			
			for(int j=0;j<graph[next].length;j++){
				System.out.println(next+">>"+j);
				if(graph[next][j] == 1){
					if(j == destination){
						return true;
					} else{
						graph[next][j] = 2;
						queue.addFirst(j);
					}
				}
			}
		}
		
		return false;
	}
}
