package com.assignment.daofab.exception;


/**
 * @author Thanh Le
 * @since 2023-10-07
 */

public class InitDataException extends Exception {
	
	public InitDataException() {
        super("Can not get data from resource file.");
    }

    public InitDataException(String message) {
        super(message);
    }
}
