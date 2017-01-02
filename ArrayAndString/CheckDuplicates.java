package com;

import java.util.HashMap;

// To check duplicate values in a given string.
public class CheckDuplicates {
	public static void main(String args[]) {
		String sentence = "Hello World";
		System.out.println(checkDuplicate(sentence));
		System.out.println(checkWithHashMap(sentence));
		System.out.println(checkWithBooleanArray(sentence));
	}

	// checkWithHashMap time complexity O(n) with a single loop for search

	public static String checkWithHashMap(String sentence) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char chars[] = sentence.toCharArray();
		for (Character c : chars) {
			if (map.containsKey(c)) {
				return "duplicate found";
			} else {
				map.put(c, 1);
			}
		}
		return "no duplicate found";
	}

	// checkWithBooleanArray time complexity O(n)
	public static String checkWithBooleanArray(String sentence) {
		boolean ch[] = new boolean[128];
		if (sentence.length() > 128) {
			return "duplicate confirmed";
		}

		for (int i = 0; i < sentence.length(); i++) {
			int charValue = sentence.charAt(i);
			if (ch[charValue] == true) {
				return "duplicate value found";
			} else {
				ch[charValue] = true;
			}
		}
		return "no duplicate values";
	}

	// checkDuplicate without any additional data structure: time complexity
	// O(n) and space complexity O(1)

	public static String checkDuplicate(String sentence) {
		for (int i = 0; i < sentence.length(); i++) {
			for (int j = i + 1; j < sentence.length(); j++) {
				if (sentence.charAt(i) == sentence.charAt(j)) {
					return "yes";
				}
			}
		}
		return "no";
	}
}