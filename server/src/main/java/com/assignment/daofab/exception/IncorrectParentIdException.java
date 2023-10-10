package com.assignment.daofab.exception;


/**
 * @author Thanh Le
 * @since 2023-10-07
 */

public class IncorrectParentIdException extends Exception {
	
	public IncorrectParentIdException() {
        super("Parent id is incorrect.");
    }

    public IncorrectParentIdException(String message) {
        super(message);
    }
}
