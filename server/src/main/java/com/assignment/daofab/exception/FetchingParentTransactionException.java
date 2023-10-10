package com.assignment.daofab.exception;


/**
 * @author Thanh Le
 * @since 2023-10-07
 */
public class FetchingParentTransactionException extends Exception {
	
	public FetchingParentTransactionException() {
        super("Error while fetching parrent.");
    }

    public FetchingParentTransactionException(String message) {
        super(message);
    }
}
