package com;

public class OneAway {

	public static void main(String args[]) {
		System.out.println(isOneEditAway("Hello", "Hello"));
	}

	// To check the compare the edits between 2 strings
	// time complexity O(n)
	public static boolean isOneEditAway(String original, String edited) {
		int changes = 0;
		int j = 0;
		int k = 0;
		if (original.length() == edited.length()) {
			for (int i = 0; i < original.length() - 1; i++) {
				if (original.charAt(i) != edited.charAt(i)) {
					changes++;
				}
			}

		} else {
			changes += 1;
			if (original.length() > edited.length()) {
				for (int i = 0; i < edited.length() - 1; i++) {
					if (original.charAt(j) != edited.charAt(i)) {
						changes++;
						j++;
					}
					j++;
				}
			} else {
				for (int i = 0; i < edited.length() - 1; i++) {
					if (original.charAt(k) != edited.charAt(i)) {
						changes++;
						k--;
					}
					k++;
				}
			}
		}
		System.out.println(changes);
		if (changes > 1) {
			return false;
		}
		return true;
	}
}
