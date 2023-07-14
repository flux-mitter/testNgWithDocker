package com.exceptions;

/**
 * @author preetammitra
 * @created 15 June 2023
 * @implNote custom exception for handling property level Exceptions
 */
@SuppressWarnings("serial")
public class PropertyFileException extends FrameworkExceptions {

	public PropertyFileException(String message) {
		super(message);
	}
	
	public PropertyFileException(String message, Throwable cause) {
		super(message, cause);
	}
	
	

}
