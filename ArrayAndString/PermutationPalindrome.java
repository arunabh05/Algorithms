package com;

public class PermutationPalindrome {
	public static void main(String args[]) {
		System.out.println(isPermutationOfPalindrome("tacocat"));
	}

	public static boolean isPermutationOfPalindrome(String sentence) {
		int charsInt[] = new int[128];
		boolean isPalindrome = false;

		for (int i = 0; i < sentence.length(); i++) {
			int value = sentence.charAt(i);
			charsInt[value] += 1;
		}

		if (sentence.length() % 2 == 0) {
			for (int i = 0; i < sentence.length(); i++) {
				if (charsInt[sentence.charAt(i)] != 2) {
					return false;
				}
			}
		} else {
			for (int i = 0; i < sentence.length(); i++) {
				if (charsInt[sentence.charAt(i)] == 1) {
					if (isPalindrome == true) {
						return false;
					}
					isPalindrome = true;
				}
			}
		}
		return true;
	}
}

