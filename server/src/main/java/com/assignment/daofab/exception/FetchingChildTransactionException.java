package com.assignment.daofab.exception;


/**
 * @author Thanh Le
 * @since 2023-10-07
 */
public class FetchingChildTransactionException extends Exception {
	
	public FetchingChildTransactionException() {
        super("Error while fetching child.");
    }

    public FetchingChildTransactionException(String message) {
        super(message);
    }
}
