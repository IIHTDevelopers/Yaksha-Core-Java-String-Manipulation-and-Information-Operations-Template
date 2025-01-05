package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;

public class AutoGrader {

	// Test for string manipulation and string information methods
	public boolean testStringMethods(String filePath) throws IOException {
		System.out.println("Starting testStringMethods with file: " + filePath);

		// Load participant's file
		File participantFile = new File(filePath); // Path to participant's file
		if (!participantFile.exists()) {
			System.out.println("File does not exist at path: " + filePath);
			return false;
		}

		// Parse the file using JavaParser
		FileInputStream fileInputStream = new FileInputStream(participantFile);
		JavaParser javaParser = new JavaParser();
		CompilationUnit cu;
		try {
			cu = javaParser.parse(fileInputStream).getResult()
					.orElseThrow(() -> new IOException("Failed to parse the Java file"));
		} catch (IOException e) {
			System.out.println("Error parsing the file: " + e.getMessage());
			throw e;
		}

		System.out.println("Parsed the Java file successfully.");

		// Flags to check for string manipulation and information methods
		boolean hasStringManipulation = false;
		boolean hasStringInformation = false;

		// 1. Checking String Manipulation Methods (substring, concat, replace,
		// toUpperCase, toLowerCase)
		System.out.println("------ Checking String Manipulation Methods ------");
		for (MethodCallExpr method : cu.findAll(MethodCallExpr.class)) {
			String methodName = method.getNameAsString();
			if (methodName.equals("substring") || methodName.equals("concat") || methodName.equals("replace")
					|| methodName.equals("toUpperCase") || methodName.equals("toLowerCase")) {
				hasStringManipulation = true;
				System.out.println("✓ Found string manipulation method: " + methodName);
			}
		}

		// Output the result for string manipulation methods
		if (hasStringManipulation) {
			System.out.println("✓ String manipulation methods are present.");
		} else {
			System.out.println("✘ Missing string manipulation methods.");
		}

		// 2. Checking String Information Methods (length, charAt, indexOf, isEmpty,
		// startsWith, endsWith)
		System.out.println("------ Checking String Information Methods ------");
		for (MethodCallExpr method : cu.findAll(MethodCallExpr.class)) {
			String methodName = method.getNameAsString();
			if (methodName.equals("length") || methodName.equals("charAt") || methodName.equals("indexOf")
					|| methodName.equals("isEmpty") || methodName.equals("startsWith")
					|| methodName.equals("endsWith")) {
				hasStringInformation = true;
				System.out.println("✓ Found string information method: " + methodName);
			}
		}

		// Output the result for string information methods
		if (hasStringInformation) {
			System.out.println("✓ String information methods are present.");
		} else {
			System.out.println("✘ Missing string information methods.");
		}

		// Test result
		boolean result = hasStringManipulation && hasStringInformation;
		System.out.println("Test result: " + result);

		return result;
	}
}
