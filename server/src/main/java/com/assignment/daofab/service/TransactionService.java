package com.assignment.daofab.service;

import com.assignment.daofab.exception.FetchingChildTransactionException;
import com.assignment.daofab.exception.FetchingParentTransactionException;
import com.assignment.daofab.exception.IncorrectParentIdException;
import com.assignment.daofab.response.ChildTransactionResponse;
import com.assignment.daofab.response.ParentTransactionResponse;
import org.springframework.data.domain.Page;

import java.util.Set;

/**
 * @author Thanh Le
 * @since 2023-10-07
 */

public interface TransactionService {

	Page<ParentTransactionResponse> getParentTransactions(int page, int size) throws FetchingParentTransactionException;

	Set<ChildTransactionResponse> getChildTransactions(long parentId) throws IncorrectParentIdException, FetchingChildTransactionException;

}
