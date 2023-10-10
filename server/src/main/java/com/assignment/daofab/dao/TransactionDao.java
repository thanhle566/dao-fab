package com.assignment.daofab.dao;

import com.assignment.daofab.model.ChildTransactionEntity;
import com.assignment.daofab.model.ParentTransactionEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Thanh Le
 * @since 2023-10-07
 */

public interface TransactionDao {

	void setParentTransactions(List<ParentTransactionEntity> parentTransactions);

	void setChildTransactionsMap(Map<Long, List<ChildTransactionEntity>> childTransactionsMap);

	Page<ParentTransactionEntity> getParentTransactions(int page, int size);
	
	List<ChildTransactionEntity> getChildTransactions(long parentId);

	Optional<ParentTransactionEntity> getParentTransaction(long parentId);

	long getTotalPaidAmountForParentTransaction(long parentId);

}
