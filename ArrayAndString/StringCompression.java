package com;

public class StringCompression {

	public static void main(String args[]) {
		System.out.println(stringCompression("aaaabbccaadda"));
		System.out.println(stringBuilderCompression("aaaabbccaadda"));
		
		
	}

	public static String stringCompression(String sentence) {
		int count = 0;
		String result = "";
		for (int i = 0; i < sentence.length(); i++) {
			if (i + 1 < sentence.length() - 1 && sentence.charAt(i) == sentence.charAt(i + 1)) {
				count++;
			} else {
				count++;
				result += sentence.charAt(i) + "" + count;
				count = 0;
			}
		}
		return result;
	}

	public static StringBuilder stringBuilderCompression(String sentence) {
		int count = 0;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < sentence.length(); i++) {
			if (i + 1 < sentence.length() - 1 && sentence.charAt(i) == sentence.charAt(i + 1)) {
				count++;
			} else {
				count++;
				result.append(sentence.charAt(i));
				result.append(count);
				count = 0;
			}
		}
		return result;
	}
}