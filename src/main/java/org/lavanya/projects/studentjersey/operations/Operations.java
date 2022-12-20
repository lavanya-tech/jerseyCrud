package org.lavanya.projects.studentjersey.operations;

public class Operations {

	public static final String HAS_ACCESS = "has_access";
	public static final String NO_ACCESS = "no_access";

	public static String toOperations(String op) {
		op.toLowerCase();
		switch (op) {
		case "has_access":
			return HAS_ACCESS;
		case "no_access":
			return NO_ACCESS;
		default:
			return null;
		}
	}
}
