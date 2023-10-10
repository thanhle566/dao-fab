package com.assignment.daofab.component;

import com.assignment.daofab.dao.TransactionDao;
import com.assignment.daofab.exception.InitDataException;
import com.assignment.daofab.model.ChildTransactionEntity;
import com.assignment.daofab.model.ParentTransactionEntity;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Thanh Le
 * @since 2023-10-07
 * 
 * This component is used to load the transaction data Parent and Child from "~/resources/json/"
 */

@Component
public class InitializeData {
	
	@Autowired
	private TransactionDao transactionDao;
	
	@PostConstruct
	private void loadData() {
		try {
			initParentTransactions();
			initChildTransactions();
		} catch (InitDataException | IOException e) {
			throw new RuntimeException("Exception Load data", e);
		}
	}
	
	private void initParentTransactions() throws IOException, InitDataException {
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data/Parent.json")) {
			if (inputStream == null) throw new InitDataException();
			String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
			ParentTransactionData parentTransactionData = new Gson().fromJson(content, ParentTransactionData.class);
			List<ParentTransactionEntity> parentTransactions = parentTransactionData.getData().stream().sorted(Comparator.comparing(ParentTransactionEntity::getId)).collect(Collectors.toList());
			transactionDao.setParentTransactions(parentTransactions);
		}
	}
	
	private void initChildTransactions() throws IOException, InitDataException {
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data/Child.json")) {
			if (inputStream == null) throw new InitDataException();
			String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
			ChildTransactionData childTransactionData = new Gson().fromJson(content, ChildTransactionData.class);
			Map<Long, List<ChildTransactionEntity>> childTransactionsMap = childTransactionData.getData().stream().collect(Collectors.groupingBy(ChildTransactionEntity::getParentId));
			transactionDao.setChildTransactionsMap(childTransactionsMap);
		}
	}
	
	private static class ParentTransactionData {
		private List<ParentTransactionEntity> data;
		
		public List<ParentTransactionEntity> getData() {
			return data;
		}
	}
	
	private static class ChildTransactionData {
		private List<ChildTransactionEntity> data;
		
		public List<ChildTransactionEntity> getData() {
			return data;
		}
	}
}
