package com.assignment.daofab.service.impl;

import com.assignment.daofab.dao.TransactionDao;
import com.assignment.daofab.exception.FetchingChildTransactionException;
import com.assignment.daofab.exception.FetchingParentTransactionException;
import com.assignment.daofab.exception.IncorrectParentIdException;
import com.assignment.daofab.model.ChildTransactionEntity;
import com.assignment.daofab.model.ParentTransactionEntity;
import com.assignment.daofab.response.ChildTransactionResponse;
import com.assignment.daofab.response.ParentTransactionResponse;
import com.assignment.daofab.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;


/**
 * @author Thanh Le
 * @since 2023-10-07
 */

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Override
	public Page<ParentTransactionResponse> getParentTransactions(int page, int size) throws FetchingParentTransactionException {
		Page<ParentTransactionEntity> result = transactionDao.getParentTransactions(page, size);
		return result.map(parentTransaction -> ParentTransactionResponse.builder()
				.id(parentTransaction.getId())
				.sender(parentTransaction.getSender())
				.receiver(parentTransaction.getReceiver())
				.totalAmount(parentTransaction.getTotalAmount())
				.totalPaidAmount(transactionDao.getTotalPaidAmountForParentTransaction(parentTransaction.getId()))
				.build());
	}

	@Override
	public Set<ChildTransactionResponse> getChildTransactions(long parentId) throws IncorrectParentIdException, FetchingChildTransactionException {
		Optional<ParentTransactionEntity> parent = transactionDao.getParentTransaction(parentId);

		if(!parent.isPresent()) throw new IncorrectParentIdException();
			
		ParentTransactionEntity parentTransaction = parent.get();
		Set<ChildTransactionResponse> childTransactionList = new TreeSet<>();

		for(ChildTransactionEntity childTransaction : transactionDao.getChildTransactions(parentTransaction.getId())) {
			childTransactionList.add(
					ChildTransactionResponse.builder()
							.id(childTransaction.getId())
							.sender(parentTransaction.getSender())
							.receiver(parentTransaction.getReceiver())
							.totalAmount(parentTransaction.getTotalAmount())
							.paidAmount(childTransaction.getPaidAmount())
							.build()
			);

		}
		return childTransactionList;
	}

}
