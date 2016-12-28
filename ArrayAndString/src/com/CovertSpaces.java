package com;

public class CovertSpaces {

	public static void main(String args[]) {
		System.out.println(convertSpaces("Mr John Smith"));
	}

	
	// convertSpaces time complexity O(n) 
	// To convert the all space in a given string with %20
	public static String convertSpaces(String sentence) {

		int spaces = 0;
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == ' ') {
				spaces++;
			}
		}
		int length = sentence.length() + spaces * 2;
		char chars[] = new char[length];
		int j = length - 1;
		for (int i = sentence.length() - 1; i >= 0; i--) {

			if (sentence.charAt(i) == ' ') {
				chars[j--] = '0';
				chars[j--] = '2';
				chars[j--] = '%';
			} else {
				chars[j--] = sentence.charAt(i);
			}
		}

		String result = new String(chars);
		return result;
	}
}