package com.assignment.daofab.dao.impl;

import com.assignment.daofab.dao.TransactionDao;
import com.assignment.daofab.model.ChildTransactionEntity;
import com.assignment.daofab.model.ParentTransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author Thanh Le
 * @since 2023-10-07
 */

@Repository
public class TransactionDaoImpl implements TransactionDao {

	private List<ParentTransactionEntity> parentTransactions;
	private Map<Long, List<ChildTransactionEntity>> childTransactionsMap;
	
	@Override
	public void setParentTransactions(List<ParentTransactionEntity> parentTransactions) {
		this.parentTransactions = parentTransactions;
	}
	
	@Override
	public void setChildTransactionsMap(Map<Long, List<ChildTransactionEntity>> childTransactionsMap) {
		this.childTransactionsMap = childTransactionsMap;
	}

	@Override
	public Page<ParentTransactionEntity> getParentTransactions(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		int start = (int) pageRequest.getOffset();
		if (start > parentTransactions.size()) start = 0;
		int end = Math.min((start + pageRequest.getPageSize()), parentTransactions.size());
		List<ParentTransactionEntity> result = parentTransactions.subList(start, end);
		return new PageImpl<>(result, pageRequest, parentTransactions.size());
	}

	@Override
	public List<ChildTransactionEntity> getChildTransactions(long parentId) {
		return childTransactionsMap.getOrDefault(parentId, Collections.emptyList());
	}

	@Override
	public Optional<ParentTransactionEntity> getParentTransaction(long parentId) {
		return parentTransactions.stream().filter(p -> p.getId() == parentId).findFirst();
	}

	@Override
	public long getTotalPaidAmountForParentTransaction(long parentId) {
		List<ChildTransactionEntity> childTransactions = childTransactionsMap.get(parentId);
		
		if(!CollectionUtils.isEmpty(childTransactions)) {
			return childTransactions.stream().mapToLong(ChildTransactionEntity::getPaidAmount).sum();
		}else {
			return 0;
		}
	}
}
