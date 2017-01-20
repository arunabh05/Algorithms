package com.StackAndQueue;

public class MultiStack {

	private int numberOfStack = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public MultiStack(int stackSize){
		stackCapacity = stackSize;
		values = new int[numberOfStack*stackSize];
		sizes = new int[numberOfStack];
	}
	
	public static void main(String args[]){
		MultiStack ms = new MultiStack(3);
		ms.push(1, 12);
		ms.push(1, 14);
		ms.push(1, 1);
		ms.push(1, 62);
		ms.push(2, 26);
		ms.pop(2);


		for(int i=0;i<ms.values.length;i++){
			System.out.println(ms.values[i]);
		}
		
	}
	
	public void push(int stackNum, int value){
		if(sizes[stackNum] == stackCapacity){
			System.out.println("Full Stack");
		}
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}
	
	public int pop(int stackNum){
		if(sizes[stackNum] == 0){
			System.out.println("Empty Stack");
		}
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNum]--;
		return value;
	}
	
	public int indexOfTop(int stackNum){
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}
}
