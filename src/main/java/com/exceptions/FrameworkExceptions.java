package com.exceptions;

/**
 * @author preetammitra
 * @created 15 June 2023
 * @implNote custom exception for handling framework level exception
 */
@SuppressWarnings("serial")
public class FrameworkExceptions extends RuntimeException {

	public FrameworkExceptions(String message) {
		super(message);
	}

	// Overloaded Constructors
	public FrameworkExceptions(String message, Throwable cause) {
		super(message, cause);
	}

}
