package com.StackAndQueue;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class AnimalShelter {
	
	LinkedList<Animal> animals = new LinkedList<Animal>();
	class Animal {
		private String type;
		private int arrivalTime;

		public Animal(String aType, int aTime) {
			type = aType;
			arrivalTime = aTime;
		}
	}

	public Animal deQueueAny() {
		return animals.removeFirst();
	}

	public Animal deQueueDog() {
		for(Animal a: animals){
			if(a.type == "dog"){
				animals.remove(a);
				return a;
			}
		}
		return new Animal("No Dog Available ", -1);
	}

	public Animal deQueueCat() {
		for(Animal a: animals){
			if(a.type == "cat"){
				animals.remove(a);
				return a;
			}
		}
		return new Animal("No Cat Available", -1);
	}

	public void enQueue(Animal animal) {
		Collections.sort(animals,new Comparator<Animal>(){
				@Override
				public int compare(Animal animal1, Animal animal2) {
					if(animal1.arrivalTime > animal2.arrivalTime){
						return 1;
					}else if(animal1.arrivalTime < animal2.arrivalTime){
						return -1;
					}else{
						return 0;
					}
				
			}
		 });
		animals.addLast(animal);
	}
	
	public static void main(String args[]){
	
		AnimalShelter aShelter = new AnimalShelter();
		aShelter.enQueue(aShelter.new Animal("dog", 1));
		aShelter.enQueue(aShelter.new Animal("cat", 2));
		aShelter.enQueue(aShelter.new Animal("cat", 3));
		aShelter.enQueue(aShelter.new Animal("dog", 4));
		aShelter.enQueue(aShelter.new Animal("dog", 5));
		
		System.out.println(aShelter.deQueueCat().arrivalTime);
		System.out.println(aShelter.deQueueAny().arrivalTime);
		System.out.println(aShelter.deQueueDog().arrivalTime);
		System.out.println(aShelter.deQueueDog().arrivalTime);
		System.out.println(aShelter.deQueueCat().arrivalTime);
		
	}
}

