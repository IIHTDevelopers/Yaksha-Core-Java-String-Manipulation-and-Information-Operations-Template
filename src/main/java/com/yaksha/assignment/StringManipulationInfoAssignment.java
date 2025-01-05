package com.yaksha.assignment;

public class StringManipulationInfoAssignment {

	public static void main(String[] args) {

		// Declare string variables
		String str1 = "Hello, World!";
		String str2 = "Java Programming";

		// 1. Perform string manipulation: substring, concat, replace, toUpperCase,
		// toLowerCase
		String subStr = str1.substring(7, 12);
		String concatenated = str1.concat(" - " + str2);
		String replaced = str1.replace("World", "Java");
		String upperCase = str1.toUpperCase();
		String lowerCase = str2.toLowerCase();

		// Print the results of string manipulation
		System.out.println("Substring: " + subStr);
		System.out.println("Concatenated: " + concatenated);
		System.out.println("Replaced: " + replaced);
		System.out.println("Uppercase: " + upperCase);
		System.out.println("Lowercase: " + lowerCase);

		// Declare string variables
		String str = "Java Programming";

		// 2. Perform string information operations: length, charAt, indexOf, isEmpty,
		// startsWith, endsWith
		int length = str.length();
		char charAt = str.charAt(5);
		int indexOfJava = str.indexOf("Java");
		boolean isEmpty = str.isEmpty();
		boolean startsWithJava = str.startsWith("Java");
		boolean endsWithProgramming = str.endsWith("Programming");

		// Print the results of string information
		System.out.println("Length: " + length);
		System.out.println("Character at index 5: " + charAt);
		System.out.println("Index of 'Java': " + indexOfJava);
		System.out.println("Is empty: " + isEmpty);
		System.out.println("Starts with 'Java': " + startsWithJava);
		System.out.println("Ends with 'Programming': " + endsWithProgramming);
	}
}
