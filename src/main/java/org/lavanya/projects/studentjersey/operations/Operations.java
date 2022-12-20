package org.lavanya.projects.studentjersey.operations;

public class Operations {

	public static final String HAS_ACCESS = "has_access";
	public static final String NO_ACCESS = "no_access";

	public static Boolean toOperations(String op) {
		switch (op) {
		case "has_access":
		case "no_access":
			return true;
		default:
			return false;
		}
	}
}
