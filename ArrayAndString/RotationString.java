package com;

public class RotationString {

	public static void main() {

	}

	public static boolean isRotation(String sentence, String sentence2) {

		if (sentence.length() > 0 && sentence.length() == sentence2.length()) {
			String stringFinder = sentence + sentence;
			return isSubstring(stringFinder, sentence2);
		}

		return false;
	}

	public static boolean isSubstring(String s1, String s2) {

		return true;
	}

}
