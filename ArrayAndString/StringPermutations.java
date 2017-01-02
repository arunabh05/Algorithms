package com;

public class StringPermutations {
	public static void main(String args[]) {
		System.out.println(checkPermutation("xyz", "xyz"));
		 PrintAllPermutations("", "xyz");
	}

	public static void PrintAllPermutations(String perm, String word) {

		if (word.isEmpty()) {
			System.out.println(">> ::" + perm + word);
		} else {
			for (int i = 0; i < word.length(); i++) {
				PrintAllPermutations(perm + word.charAt(i),
						word.substring(0, i) + word.substring(i + 1, word.length()));
			}
		}
	}

	public static boolean checkPermutation(String firstStr, String secondStr) {

		if (firstStr.length() == secondStr.length()) {
			char[] firstChar = firstStr.toCharArray();
			char[] secondChar = secondStr.toCharArray();

			java.util.Arrays.sort(firstChar);
			java.util.Arrays.sort(secondChar);

			String Str1 = new String(firstChar);
			String Str2 = new String(secondChar);

			if (Str1.equals(Str2)) {
				return true;
			}
		}
		return false;
	}

}
