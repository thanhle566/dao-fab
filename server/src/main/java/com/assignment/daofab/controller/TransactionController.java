package com.assignment.daofab.controller;

import com.assignment.daofab.config.APIController;
import com.assignment.daofab.exception.FetchingChildTransactionException;
import com.assignment.daofab.exception.FetchingParentTransactionException;
import com.assignment.daofab.exception.IncorrectParentIdException;
import com.assignment.daofab.response.ChildTransactionResponse;
import com.assignment.daofab.response.ParentTransactionResponse;
import com.assignment.daofab.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author Thanh Le
 * @since 2023-10-07
 */

@RestController
@RequestMapping(APIController.TRANSACTION_PATH)
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/parent")
	public ResponseEntity<Page<ParentTransactionResponse>> getParentTransactions(
			@RequestParam(value = "page", required = false, defaultValue = "0") Integer page, 
			@RequestParam(value = "size", required = false, defaultValue = "2") Integer size)
			throws FetchingParentTransactionException {
		Page<ParentTransactionResponse> parentTransactions = transactionService.getParentTransactions(page, size);
		return ResponseEntity
				.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(parentTransactions);
	}

	@GetMapping("/children/{parentId}")
	public ResponseEntity<Set<ChildTransactionResponse>> getChildTransactions(
			@PathVariable("parentId") long parentId)
			throws IncorrectParentIdException, FetchingChildTransactionException {
		Set<ChildTransactionResponse> childTransactions = transactionService.getChildTransactions(parentId);
		return ResponseEntity
				.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(childTransactions);
	}
}
